package librarySystem;

/**
 * Custom exception for when an item is already borrowed
 */
public class BookAlreadyBorrowedException extends Exception {
    private String itemTitle;
    private String borrower;
    
    public BookAlreadyBorrowedException(String itemTitle, String borrower) {
        super();
        this.itemTitle = itemTitle;
        this.borrower = borrower;
    }
    
    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
    
    @Override
    public String getMessage() {
        if (itemTitle != null && borrower != null) {
            return "Item '" + itemTitle + "' is already borrowed by " + borrower;
        }
        return super.getMessage();
    }
    
    @Override
    public String toString() {
        return "BookAlreadyBorrowedException: " + getMessage();
    }
    
    public String getItemTitle() {
        return itemTitle;
    }
    
    public String getBorrower() {
        return borrower;
    }
}
