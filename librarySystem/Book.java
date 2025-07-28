package librarySystem;

/**
 * Book class inheriting from Item
 */
public class Book extends Item {
    private String isbn;
    private int pages;
    
    public Book(String title, String author, String isbn, int pages) {
        super(title, author);
        this.isbn = isbn;
        this.pages = pages;
    }
    
    @Override
    public String getDetails() {
        return String.format("Book: %s by %s, ISBN: %s, Pages: %d, Borrowed: %s%s",
                title, author, isbn, pages, isBorrowed ? "Yes" : "No",
                isBorrowed ? " (by " + borrower + ")" : "");
    }
    
    // Getters and setters
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getPages() {
        return pages;
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }
}
