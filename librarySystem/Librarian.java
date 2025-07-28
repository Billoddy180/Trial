package librarySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Librarian class managing the library with exception handling and File I/O
 */
public class Librarian {
    private String name;
    private Library library;
    
    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }
    
    /**
     * Check out an item - throws BookAlreadyBorrowedException if already borrowed
     */
    public void checkOutBorrowedItem(Item item, String borrowerName) throws BookAlreadyBorrowedException {
        if (item.isBorrowed()) {
            throw new BookAlreadyBorrowedException(item.getTitle(), item.getBorrower());
        }
        
        item.setBorrowed(true);
        item.setBorrower(borrowerName);
        System.out.println("Item '" + item.getTitle() + "' has been checked out to " + borrowerName);
    }
    
    /**
     * Check out item with proper exception handling
     */
    public void safeCheckOut(Item item, String borrowerName) {
        try {
            checkOutBorrowedItem(item, borrowerName);
        } catch (BookAlreadyBorrowedException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Please choose a different item or wait for this one to be returned.");
        }
    }
    
    /**
     * Return an item
     */
    public void returnItem(Item item) {
        if (item.isBorrowed()) {
            System.out.println("Item '" + item.getTitle() + "' has been returned by " + item.getBorrower());
            item.setBorrowed(false);
            item.setBorrower(null);
        } else {
            System.out.println("Item '" + item.getTitle() + "' was not borrowed.");
        }
    }
    
    /**
     * Save catalog to file
     */
    public void saveCatalogToFile(String filename) {
        try {
            File file = new File(filename);
            PrintWriter writer = new PrintWriter(file);
            
            writer.println("Library: " + library.getName());
            writer.println("Location: " + library.getLocation());
            writer.println("Librarian: " + name);
            writer.println("Catalog Size: " + library.getCatalogSize());
            writer.println("========================");
            
            for (Item item : library.getCatalog()) {
                writer.println(item.getDetails());
            }
            
            writer.close();
            System.out.println("Catalog successfully saved to " + filename);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not create or write to file " + filename);
            System.err.println("Reason: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while saving catalog: " + e.getMessage());
        }
    }
    
    /**
     * Read catalog from file
     */
    public void readCatalogFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            System.out.println("Reading catalog from file: " + filename);
            System.out.println("=====================================");
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            scanner.close();
            System.out.println("=====================================");
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: File " + filename + " not found.");
            System.err.println("Please make sure the file exists and the path is correct.");
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    /**
     * Display library information
     */
    public String getLibraryInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Librarian: ").append(name).append("\n");
        info.append("Library: ").append(library.getName()).append("\n");
        info.append("Location: ").append(library.getLocation()).append("\n");
        info.append("Catalog Size: ").append(library.getCatalogSize()).append("\n");
        return info.toString();
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Library getLibrary() {
        return library;
    }
    
    public void setLibrary(Library library) {
        this.library = library;
    }
}
