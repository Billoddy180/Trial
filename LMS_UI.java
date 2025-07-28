import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import librarySystem.*;

/**
 * JavaFX GUI for Library Management System
 */
public class LMS_UI extends Application {
    
    private Library library;
    private Librarian librarian;
    private TextArea displayArea;
    
    @Override
    public void start(Stage stage) {
        // Initialize sample data
        initializeSampleData();
        
        // Set up the primary stage
        stage.setTitle("Library Management System");
        
        // Create the main layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        
        // Title
        Label titleLabel = new Label("Library Management System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        // Create input form for interactive features (Bonus)
        GridPane inputForm = createInputForm();
        
        // Create display area
        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefRowCount(15);
        displayArea.setPrefColumnCount(50);
        
        // Initial display
        updateDisplay();
        
        // Add components to main layout
        mainLayout.getChildren().addAll(
            titleLabel,
            new Separator(),
            inputForm,
            new Separator(),
            new Label("Library Information:"),
            displayArea
        );
        
        // Create and set the scene
        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Create interactive input form (Bonus Question)
     */
    private GridPane createInputForm() {
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setAlignment(Pos.CENTER);
        
        // Input fields
        TextField librarianNameField = new TextField();
        TextField libraryNameField = new TextField();
        TextField locationField = new TextField();
        
        // Labels
        Label librarianNameLabel = new Label("Librarian Name:");
        Label libraryNameLabel = new Label("Library Name:");
        Label locationLabel = new Label("Library Location:");
        
        // Submit button
        Button submitButton = new Button("Update Library Info");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        
        // Button action
        submitButton.setOnAction(e -> {
            String librarianName = librarianNameField.getText().trim();
            String libraryName = libraryNameField.getText().trim();
            String location = locationField.getText().trim();
            
            if (!librarianName.isEmpty() && !libraryName.isEmpty() && !location.isEmpty()) {
                // Update the library and librarian with new information
                library.setName(libraryName);
                library.setLocation(location);
                librarian.setName(librarianName);
                
                // Update display
                updateDisplay();
                
                // Show confirmation
                displayArea.appendText("\n=== UPDATED ===\n");
                displayArea.appendText("Library information has been updated successfully!\n");
                displayArea.appendText("==================\n");
                
                // Clear fields
                librarianNameField.clear();
                libraryNameField.clear();
                locationField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input Error");
                alert.setHeaderText("Missing Information");
                alert.setContentText("Please fill in all fields before submitting.");
                alert.showAndWait();
            }
        });
        
        // Add components to form
        form.add(librarianNameLabel, 0, 0);
        form.add(librarianNameField, 1, 0);
        form.add(libraryNameLabel, 0, 1);
        form.add(libraryNameField, 1, 1);
        form.add(locationLabel, 0, 2);
        form.add(locationField, 1, 2);
        form.add(submitButton, 1, 3);
        
        return form;
    }
    
    /**
     * Initialize sample data for the library
     */
    private void initializeSampleData() {
        // Create library
        library = new Library("Central City Library", "123 Main Street, Central City");
        
        // Create librarian
        librarian = new Librarian("Ms. Sarah Johnson", library);
        
        // Add sample books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", 376);
        Book book2 = new Book("1984", "George Orwell", "978-0-452-28423-4", 328);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", 432);
        
        // Add sample journals
        Journal journal1 = new Journal("Nature", "Various Authors", "0028-0836", 595, 7865);
        Journal journal2 = new Journal("Science", "Various Authors", "0036-8075", 375, 6602);
        
        // Add items to library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(journal1);
        library.addItem(journal2);
        
        // Demonstrate borrowing functionality
        try {
            librarian.checkOutBorrowedItem(book1, "John Doe");
            librarian.checkOutBorrowedItem(journal1, "Jane Smith");
        } catch (BookAlreadyBorrowedException e) {
            System.err.println("Error during sample data setup: " + e.getMessage());
        }
    }
    
    /**
     * Update the display area with current library information
     */
    private void updateDisplay() {
        StringBuilder display = new StringBuilder();
        
        // Library information
        display.append("=== LIBRARY INFORMATION ===\n");
        display.append("Librarian Name: ").append(librarian.getName()).append("\n");
        display.append("Library Name: ").append(library.getName()).append("\n");
        display.append("Location: ").append(library.getLocation()).append("\n");
        display.append("Catalog Size: ").append(library.getCatalogSize()).append(" items\n\n");
        
        // List of items
        display.append("=== CATALOG ITEMS ===\n");
        for (int i = 0; i < library.getCatalog().size(); i++) {
            display.append((i + 1)).append(". ").append(library.getCatalog().get(i).getDetails()).append("\n");
        }
        
        // Additional statistics
        display.append("\n=== STATISTICS ===\n");
        long borrowedCount = library.getCatalog().stream().mapToLong(item -> item.isBorrowed() ? 1 : 0).sum();
        long availableCount = library.getCatalogSize() - borrowedCount;
        display.append("Available Items: ").append(availableCount).append("\n");
        display.append("Borrowed Items: ").append(borrowedCount).append("\n");
        
        displayArea.setText(display.toString());
    }
    
    /**
     * Main method to launch the JavaFX application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
