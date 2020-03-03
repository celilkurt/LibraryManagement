

package libraryman.entity;


public interface IUser {
   
    public void logout();
    public boolean compare(String userName, String password);
    public String getType();

    public String getUserName();
    
}
