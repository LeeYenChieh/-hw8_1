import java.util.ArrayList;
public class BorrowerHandler implements TransactionHandler{
    public int checkoutBooks(User staff, User borrower, ArrayList<Book> CheckingOut, ArrayList<Book> books, ArrayList<User> users){
        System.out.println("Borrower can not check out the books");
        return -1;
    }
    public int returnBook(User staff, int id, ArrayList<Book> books){
        System.out.println("Borrower can not return book");
        return -1;
    }

    public int addBook(int MaxId, String bookAuthor, String BookSubject, ArrayList<Book> books){
        System.out.println("Borrower can not add book");
        return -1;
    }
    public int removeBook(int Removing, ArrayList<Book> books){
        System.out.println("Borrower can not remove book");
        return -1;
    }

    public int listAuthor(String Author, ArrayList<Book> books){
        for(Book b: books){
            if(b.Author.equals(Author)){
                System.out.printf("ID: %s Author: %s Subject: %s\n", b.id, b.Author, b.Subject);
            }
        }
        return 0;
    }
    public int listSubject(String Subject, ArrayList<Book> books){
        for(Book b: books){
            if(b.Subject.equals(Subject)){
                System.out.printf("ID: %s Author: %s Subject: %s\n", b.id, b.Author, b.Subject);
            }
        }
        return 0;
    }

    public int findChecked(String user1, String user2, ArrayList<User> users){
        if(!user1.equals(user2)){
            System.out.println("Borrower can not find books checked out by other users");
            return -1;
        }
        User borrower = null;
        for(User u: users){
            if(u.userName.equals(user1)){
                borrower = u;
                break;
            }
        }
        for(Book b: borrower.borrowedBooks){
            System.out.printf("ID: %s Author: %s Subject: %s\n", b.id, b.Author, b.Subject);
        }
        return 0;
    }
    public int findBorrower(Book book){
        System.out.println("Borrower can not find the borrower");
        return -1;
    }
}
