
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class UserServer extends UnicastRemoteObject implements UserRemoto {
    
    Connection db;
    Statement st;
    
    public UserServer(Conection con) throws RemoteException {
        super();
        
        try {
            con.conect();    
            System.out.println("UserServer Conectado ao banco");
            
            this.db = con.getC();
            this.st = (Statement) con.getStatment();
            
        } catch (Exception e) {
            System.out.println("Erro ao conectar");
        }
    }
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException{
        Conection con = new Conection();
        UserServer userServer = new UserServer(con);
        
        Naming.rebind("//localhost/UserServer", userServer);
    }
    
    @Override
    public User getUserById(int id) throws RemoteException{
        
        try {
            PreparedStatement ps = db.prepareStatement("SELECT lg.id, lg.username FROM login lg WHERE lg.id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            User user = new User();
            user.setId(0);

            if (rs != null) {
                while(rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                }

                rs.close();
            }

            if (user.getId() == 0) {
                return null;
            }

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    @Override
    public int login(String login, String password) throws RemoteException{
        int id = 0;
        
        try {
            PreparedStatement ps = db.prepareStatement("SELECT id FROM login lg WHERE lg.username = ? AND lg.password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()) {
                    id = rs.getInt("id");
                }
                
                rs.close();
            }
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(UserServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    @Override
    public Boolean register(String login, String password) throws RemoteException{        
        try {
            PreparedStatement ps = db.prepareStatement("INSERT INTO login(username, password) VALUES (?,?);");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao insetir registro");
            System.out.println(e);
            return false;
        }
    }
  
    /**
     *
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public Boolean deleteUser(String login, String password) throws RemoteException{
        
        try {
            int isExist = login(login, password);
            
            if (isExist == 0) {
                return false;
            }
            
            PreparedStatement ps = db.prepareStatement("DELETE FROM login lg WHERE lg.username = ? AND lg.password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public User getUser(User user) throws RemoteException {
        return new User(user.getId(), user.getUsername()); //To change body of generated methods, choose Tools | Templates.
    }
}
