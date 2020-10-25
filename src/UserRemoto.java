
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public interface UserRemoto extends Remote{
    User getUser(User user) throws RemoteException;
    User getUserById(int id) throws RemoteException;
    int login(String login, String password) throws RemoteException;
    Boolean register(String login, String password) throws RemoteException;
    Boolean deleteUser(String login, String password) throws RemoteException;
}
