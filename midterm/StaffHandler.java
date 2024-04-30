import java.util.ArrayList;

public class StaffHandler implements TransactionHandler{
    public int checkoutBooks(User staff, User borrower, ArrayList<Book> CheckingOut, ArrayList<Book> books, ArrayList<User> users){
        if(staff.userType.equals("Borrower")){
            System.out.println("Borrower can not check out the books");
            return -1;
        }
        if(borrower.userType.equals("Staff")){
            System.out.println("Error");
            return -1;
        }
        for(Book b: CheckingOut){
            if(b.isAvailable()){
                if(borrower.maxCheckoutNum == borrower.borrowedBooks.size()){
                    System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
                    return -1;
                }
                b.checkout(borrower);
                borrower.checkout(b);
            }
        }
        return 0;
    }
    public int returnBook(User staff, int id, ArrayList<Book> books){
        for(Book b: books){
            if(b.id == id){
                if(b.isAvailable()){
                    System.out.println("Can not return since the book isn't checked out");
                }else{
                    b.returnBook();
                    b.lastBorrower.borrowedBooks.remove(b);
                }
                return 0;
            }
        }

        return 1;
    }   

    public int addBook(int MaxId, String bookAuthor, String BookSubject, ArrayList<Book> books){
        Book newBook = new Book(MaxId, bookAuthor, BookSubject);
        books.add(newBook);
        return 0;
    }
    public int removeBook(int RemovingId, ArrayList<Book> books){
        for(Book b: books){
            if(b.id == RemovingId){
                if(b.isBorrowed){
                    return 1;
                }
                books.remove(b);
                return 0;
            }
        }
        return 1;
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
        User user2_object = null;
        for(User u: users){
            if(u.userName.equals(user2)){
                user2_object = u;
                break;
            }
        }
        if(user2_object == null || !user2_object.userType.equals("Borrower")) {
        	return 1;
        }
        for(Book b: user2_object.borrowedBooks){
            System.out.printf("ID: %s Author: %s Subject: %s\n", b.id, b.Author, b.Subject);
        }
        return 0;
    }
    public int findBorrower(Book book){
        System.out.printf("User: %s\n", book.lastBorrower.userName);
        return 0;
    }
}