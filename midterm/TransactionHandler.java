import java.util.ArrayList;
public interface TransactionHandler {
    public int checkoutBooks(User staff, User borrower, ArrayList<Book> CheckingOut, ArrayList<Book> books, ArrayList<User> users);
    public int returnBook(User staff, int id, ArrayList<Book> books);

    public int addBook(int MaxId, String bookAuthor, String BookSubject, ArrayList<Book> books);
    public int removeBook(int Removing, ArrayList<Book> books);

    public int listAuthor(String Author, ArrayList<Book> books);
    public int listSubject(String Subject, ArrayList<Book> books);

    public int findChecked(String user1, String user2, ArrayList<User> users);
    public int findBorrower(Book book);
}   