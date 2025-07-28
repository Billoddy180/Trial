import librarySystem.*;

/**
 * Test class to demonstrate the library system functionality
 */
public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("=== Library Management System Test ===\n");
        
        // Create library
        Library library = new Library("Central University Library", "456 University Ave");
        
        // Create librarian
        Librarian librarian = new Librarian("Dr. Emily Watson", library);
        
        // Create sample items
        Book book1 = new Book("Java: The Complete Reference", "Herbert Schildt", "978-0-07-180856-6", 1248);
        Book book2 = new Book("Clean Code", "Robert Martin", "978-0-13-235088-4", 464);
        Journal journal1 = new Journal("IEEE Computer", "IEEE", "0018-9162", 54, 8);
        Journal journal2 = new Journal("ACM Communications", "ACM", "0001-0782", 66, 7);
        
        // Add items to library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(journal1);
        library.addItem(journal2);
        
        // Display initial library info
        System.out.println(librarian.getLibraryInfo());
        System.out.println(library.displayCatalog());
        
        // Test exception handling
        System.out.println("=== Testing Exception Handling ===");
        
        // First checkout should succeed
        librarian.safeCheckOut(book1, "Alice Johnson");
        
        // Second checkout of same book should throw exception
        librarian.safeCheckOut(book1, "Bob Smith");
        
        // Test direct exception throwing
        try {
            librarian.checkOutBorrowedItem(book1, "Charlie Brown");
        } catch (BookAlreadyBorrowedException e) {
            System.out.println("Caught exception: " + e.toString());
        }
        
        // Return the book
        librarian.returnItem(book1);
        
        // Now checkout should work
        librarian.safeCheckOut(book1, "David Wilson");
        
        System.out.println("\n=== Updated Catalog ===");
        System.out.println(library.displayCatalog());
        
        // Test File I/O
        System.out.println("\n=== Testing File I/O ===");
        String filename = "library_catalog.txt";
        
        // Save catalog to file
        librarian.saveCatalogToFile(filename);
        
        // Read catalog from file
        librarian.readCatalogFromFile(filename);
        
        // Test reading non-existent file
        librarian.readCatalogFromFile("non_existent_file.txt");
        
        System.out.println("\n=== Test Complete ===");
    }
}
