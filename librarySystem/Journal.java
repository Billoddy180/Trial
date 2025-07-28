package librarySystem;

/**
 * Journal class inheriting from Item
 */
public class Journal extends Item {
    private String issn;
    private int volume;
    private int issue;
    
    public Journal(String title, String author, String issn, int volume, int issue) {
        super(title, author);
        this.issn = issn;
        this.volume = volume;
        this.issue = issue;
    }
    
    @Override
    public String getDetails() {
        return String.format("Journal: %s by %s, ISSN: %s, Volume: %d, Issue: %d, Borrowed: %s%s",
                title, author, issn, volume, issue, isBorrowed ? "Yes" : "No",
                isBorrowed ? " (by " + borrower + ")" : "");
    }
    
    // Getters and setters
    public String getIssn() {
        return issn;
    }
    
    public void setIssn(String issn) {
        this.issn = issn;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public int getIssue() {
        return issue;
    }
    
    public void setIssue(int issue) {
        this.issue = issue;
    }
}
