
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class Conection {
    private String local = "localhost";
    private String user = "postgres";
    private String senha = "postgres";
    private final String porta = "5433";
    private final String banco = "rmi";
    private String strConexao = "jdbc:postgresql://"+ local +":" + porta +"/"+ banco;
    private String driverJDBC = "org.postgresql.Driver";
    private Connection c;
    private Statement statment;
    
    public Conection() {}

    public void conect(){
        try {
            Class.forName(getDriverJDBC());
            setC(DriverManager.getConnection(getStrConexao(), getUser(), getSenha()));
            setStatment(getC().createStatement());
        }catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    public void disconect(){
        try {
            getC().close();
        }catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }
    
    public String getLocal() {
            return local;
    }

    public void setLocal(String local) {
            this.local = local;
    }

    public String getUser() {
            return user;
    }

    public void setUser(String user) {
            this.user = user;
    }

    public String getSenha() {
            return senha;
    }

    public void setSenha(String senha) {
            this.senha = senha;
    }

    public Connection getC() {
            return c;
    }

    public void setC(Connection c) {
            this.c = c;
    }

    public Statement getStatment() {
            return statment;
    }

    public void setStatment(Statement statment) {
            this.statment = statment;
    }

    public String getStrConexao() {
            return strConexao;
    }

    public void setStrConexao(String str_conexao) {
            this.strConexao = str_conexao;
    }

    public String getDriverJDBC() {
        return driverJDBC;
    }

    public void setDriverJDBC(String driverJDBC) {
        this.driverJDBC = driverJDBC;
    }
}
