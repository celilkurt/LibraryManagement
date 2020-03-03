/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryman.entity;

/**
 *
 * @author asus
 */
public class Admin implements IUser {

    private String userName;
    private String password;
    
    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Admin() {
    }
    
    @Override
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public String getType(){
        return "Admin";
    }
    
    
    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compare(String userName, String password) {
        return userName.equals(this.userName) && password.equals(this.password);
    }
    
    
    
}
