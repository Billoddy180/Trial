package librarySystem;

/**
 * Abstract base class for library items
 */
public abstract class Item {
    protected String title;
    protected String author;
    protected boolean isBorrowed;
    protected String borrower;
    
    public Item(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.borrower = null;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract String getDetails();
    
    // Getters and setters
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }
    
    public String getBorrower() {
        return borrower;
    }
    
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
