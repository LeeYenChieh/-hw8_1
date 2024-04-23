public class Book{
    public static int id;
    public static String Author;
    public static String Subject;

    public static User lastBorrower;
    public static boolean isBorrowed;

    Book(int id, String Author, String Subject){
        this.id = id;
        this.Author = Author;
        this.Subject = Subject;

        this.lastBorrower = null;
        this.isBorrowed = false;
    }

    public  void checkout(User borrower){
        this.lastBorrower = borrower;
        this.isBorrowed = true;
    }

    public  void returnBook(){
        this.isBorrowed = false;
    }



    public  boolean isAvailable(){
        return !isBorrowed;
    }
}