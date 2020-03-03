/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryman.entity;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class User implements IUser{
    
    private String userName;
    private String password;
    private ArrayList<Book> books;

    public User(String userName, String password, ArrayList<Book> books) {
        this.userName = userName;
        this.password = password;
        this.books = books;
    }

    public User() {
    }
    
    @Override
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    
    @Override
    public String getType(){
        return "User";
    }
    
    @Override
    public void logout() {
        System.out.println("Çıkış yapılıyor.");
    }

    @Override
    public boolean compare(String userName, String password) {
        return userName.equals(this.userName) && password.equals(this.password);
    }
    
    
    public Book returnBook(String bookName){
        
        for(Book tempBook: books)
            if(tempBook.getName().equals(bookName)){
                books.remove(tempBook);
                System.out.println("Kitap iade edildi.");
                return tempBook;
            }
        
        System.out.println("Kitap bulunamadı.");
        return null;
    } 
    
    public void printAllBooks(){
        
        books.forEach((tempBook) -> {
            System.out.println(tempBook.toString());
        });
    }
    
}
