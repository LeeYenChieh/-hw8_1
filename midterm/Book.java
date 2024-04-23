public class Book{
    public int id;
    public String Author;
    public String Subject;

    public  User lastBorrower;
    public boolean isBorrowed;

    public Book(int id, String Author, String Subject){
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