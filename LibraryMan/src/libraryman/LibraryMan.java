

package libraryman;

import java.util.ArrayList;
import java.util.Scanner;
import libraryman.entity.Book;
import libraryman.entity.IUser;
import libraryman.entity.User;

/*
            Kütüphane yönetim uygulaması
            Kullanıcının yapabilceği işlemler:
                Yönetici kaydı oluşturma
                Kullanıcı kaydı oluşturma
                Sisteme giriş yapma(Kayıt oluşturabilmek için yönetici oturumu açılmış olmalı)
                Sistemden çıkış yapma
                Kitap kaydı oluşturma
                Kitap kaydı silme
                Kitap kaydı güncelleme
                Kitap ödünç alma
                Kitabı geri verme
                
        */

public class LibraryMan {

   
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        
        
        String options = "Giriş yapmak için 1'e\n" + 
                        "Çıkış yapmak için 2'e\n" +
                        "Kayıt olmak için 3'e\n" +
                         "Kitap işlemleri için 4'e\n"
                        + "Seçenekleri tekrar yazdırmak için 5'e\n" + 
                        "Çıkmak için 0'a basınız.\n";
        
        String accountType = "Yönetici için 1'e\n" +
                            "Kullanıcı için 2'e basınız.\n";
                        
                      
        Session session = new Session("Guess",new ArrayList<IUser>());
        
        System.out.println(options);
        
        int choice = -1;
        while(choice != 0){
            
            choice = sc.nextInt();
            switch(choice){
                
                case 1:
                    
                    if(session.getAccountType().equals("Guess")){
                        
                        sc.nextLine();
                        System.out.print("Kullanıcı adı: ");
                        String userName = sc.nextLine();
                        System.out.print("Şifre: ");
                        String password = sc.nextLine();
                        
                        if(session.login(userName, password))
                            System.out.println("Giriş yaptın.");
                        else
                            System.out.println("Bilgiler hatalı.");
                        
                    }else{
                        System.out.println("Önce çıkış yapmanız gerekiyor.");
                    }
                    
                    
                    break;
                case 2:
                    
                    if(!session.getAccountType().equals("Guess")){
                        
                        session.setAccountType("Guess");
                        System.out.println("Çıkış yaptınız.");
                    }else
                        System.out.println("Misafirken çıkış yapamazsınız.");
                    
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------------------");
                    System.out.print(accountType);
                    int i = sc.nextInt();
                    
                    if(i == 1){
                        sc.nextLine();
                        System.out.print("Kullancı adı: ");
                        String userName = sc.nextLine();
                        System.out.print("Şifre: ");
                        String password = sc.nextLine();
                        
                        if(session.login(userName, password))
                            System.out.println("Kullanıcı zaten kayıtlı.");
                        else{
                            session.addAccount(userName, password, "Admin");
                        }
                        
                    }else if(i == 2){
                        
                        sc.nextLine();
                        System.out.print("Kullancı adı: ");
                        String userName = sc.nextLine();
                        System.out.print("Şifre: ");
                        String password = sc.nextLine();
                        
                        if(session.login(userName, password))
                            System.out.println("Kullanıcı zaten kayıtlı.");
                        else{
                            session.addAccount(userName, password, "User");
                        }
                        
                    }
                    
                    
                    break;
                case 4:
                    
                    if(session.getAccountType().equals("Admin")){
                        System.out.println("Kitap kaydı oluşturmak için 1'e" +
                                            "Kitap kaydı silmek için 2'e basınız");
                        
                        int choice2 = sc.nextInt();
                        switch(choice2){
                            
                            case 1:
                                sc.nextLine();
                                System.out.print("Kitap adı: ");
                                String bookName = sc.nextLine();
                                System.out.print("Yazar adı:");
                                String authorName = sc.nextLine();
                                System.out.print("Sayfa sayısı: ");
                                int pageNumber = sc.nextInt();
                                
                                if(pageNumber > 0){
                                    session.getBooks().add(new Book(bookName,authorName,pageNumber));
                                    System.out.println("Kitap eklendi.");
                                }else
                                    System.out.println("Sayfa sayısı tutarsız!!!");
                                
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.print("Kitap adı: ");
                                String bookName2 = sc.nextLine();
                                
                                session.removeBook(bookName2);
                                break;                           
                            
                        }
                    }else if(session.getAccountType().equals("User")){
                        
                        System.out.println("Kitap ödünç almak için 1'e\n" + 
                                            "Kitap iade etmek için 2'e\n " +
                                            "Kütüphanedeki kitapları görüntülemek için 3'e\n" + 
                                            "Ödünç aldığın kitapları görüntülemek için 4'e basınız.\n");
                        int choice3 = sc.nextInt();
                        
                        switch(choice3){
                            
                            case 1:
                                sc.nextLine();
                                System.out.println("Kitap ismi: ");
                                String bookName = sc.nextLine();
                                session.borrowBook(bookName);
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.println("Kitap ismi: ");
                                String bookName2 = sc.nextLine();
                                Book tempBook = ((User)session.getCurrentUser()).returnBook(bookName2);
                                
                                if(tempBook != null)
                                    session.getBooks().add(tempBook);
                                
                                break;
                            case 3:
                                session.printAllBooks();
                                break;
                            case 4:
                                ((User)session.getCurrentUser()).printAllBooks();
                                break;
                             
                                
                        }
                        
                        
                        
                    }else{
                        System.out.println("Kitap işlemleri için oturum açmalısın.");
                    }
                    
                    break;
                case 5:
                    System.out.println(options);
                    break;
                
                
            }
            
        }
        
        
        
        
    }
    
}
