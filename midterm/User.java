import java.util.ArrayList;
public class User{
    String userType;
    String userName;
    ArrayList<Book> borrowedBooks;
    int maxCheckoutNum;

    User(String userType, String userName, int maxCheckoutNum){
        this.userType = userType;
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
        this.maxCheckoutNum = maxCheckoutNum;
    }
    public void checkout(Book book){
        this.borrowedBooks.add(book);
    }
    public void returnBook(Book book){
        this.borrowedBooks.remove(book);
    }
}