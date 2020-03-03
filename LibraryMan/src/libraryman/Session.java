

package libraryman;

import java.util.ArrayList;
import libraryman.entity.Admin;
import libraryman.entity.Book;
import libraryman.entity.IUser;
import libraryman.entity.User;


public class Session {
    
    private String accountType;
    private IUser currentUser;
    private ArrayList<IUser> users;
    private ArrayList<Book> books;

    public Session(String accountType, ArrayList<IUser> users) {
        this.accountType = accountType;
        this.users = users;
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    

    public Session() {
    }

    public IUser getCurrentUser() {
        return currentUser;
    }
    
    

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public ArrayList<IUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<IUser> users) {
        this.users = users;
    }
    
    public boolean login(String userName, String password){
        
        for(IUser tempUser: users)
            if(tempUser.compare(userName, password)){
                accountType = tempUser.getType();
                currentUser = tempUser;
                return true;
            }
                
        return false;
    }
    
    public void addAccount(String userName, String password, String type){
        
        if(type.equals("Admin"))
            users.add(new Admin(userName,password));
        else{
            users.add(new User(userName,password,new ArrayList<Book>()));
        }
    }
    
    public void removeBook(String bookName){
        
        for(Book tempBook: books)
            if(tempBook.getName().equals("bookName")){
                books.remove(tempBook);
                System.out.println("Kitap silindi.");
                return;
            }
                
        System.out.println("Kitap kayıtlarda yok.");
        
        
    }
    
    public void borrowBook(String bookName){
     
        for(Book tempBook: books)
            if(tempBook.getName().equals(bookName)){
                ((User)currentUser).getBooks().add(tempBook);
                books.remove(tempBook);
                System.out.println("Kitap ödünç alındı.");
                return;
            }
        
        System.out.println("Kitap bulunamadı.");
        
    }   
    
    public void printAllBooks(){
        
        books.forEach((tempBook) -> {
            System.out.println(tempBook.toString());
        });
    }
    
    
}
