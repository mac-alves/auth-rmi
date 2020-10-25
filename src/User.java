
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class User implements Serializable {
    int id;
    String username;
    
    public User() {};
    
    public User(int id, String username){
        this.id = id;
        this.username = username;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setUsername(String userName){
        this.username = userName;
    }
    
    public String getUsername(){
        return this.username;
    }
}
