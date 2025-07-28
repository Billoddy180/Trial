# Advanced Java Library Management System

This project is an advanced Java library management system that demonstrates key Java concepts including:

- Object-Oriented Programming (inheritance, polymorphism, abstraction)
- Exception Handling (custom exceptions, try-catch blocks)
- File I/O operations
- JavaFX GUI development
- Interactive user interfaces

## Project Structure

```
librarySystem/
├── Item.java                        // Abstract base class for library items
├── Book.java                        // Book class inheriting from Item
├── Journal.java                     // Journal class inheriting from Item
├── Library.java                     // Library management class
├── Librarian.java                   // Librarian management class with File I/O
├── BookAlreadyBorrowedException.java // Custom exception class
LMS_UI.java                          // JavaFX GUI application
LibraryTest.java                     // Test/demo class
run_gui.sh                           // Script to run the GUI application
```

## Features Implemented

### Question 1: Exception Handling (20 Points)
- **BookAlreadyBorrowedException**: Custom exception class with meaningful error messages
- **Librarian.checkOutBorrowedItem()**: Method that throws the custom exception
- **Try-catch blocks**: Proper exception handling throughout the application
- **Demonstrations**: Shows proper use of `throw`, `throws`, and `try-catch`

### Question 2: File I/O (20 Points)
- **saveCatalogToFile()**: Saves library catalog to a text file using PrintWriter
- **readCatalogFromFile()**: Reads catalog from file using Scanner
- **Error Handling**: Proper FileNotFoundException handling with meaningful messages
- **File Operations**: Demonstrates file creation, writing, and reading

### Question 3: JavaFX GUI (10 Points)
- **LMS_UI class**: Extends javafx.application.Application
- **GUI Components**: Uses TextArea, Labels, GridPane layout
- **Information Display**: Shows librarian name, library details, catalog information
- **Stage and Scene**: Proper JavaFX window setup

### Bonus: Interactive GUI (20 Points)
- **Interactive Forms**: TextFields for user input
- **Event Handling**: Button actions using setOnAction()
- **Dynamic Updates**: Real-time updates to the display area
- **Input Validation**: Proper validation and error messages

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- JavaFX libraries

### Compilation
```bash
# Compile the library system classes
javac librarySystem/*.java LibraryTest.java

# Compile the JavaFX GUI (adjust module path as needed)
javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml LMS_UI.java
```

### Running the Applications

#### Console Application
```bash
java LibraryTest
```

#### JavaFX GUI Application
```bash
# Using the provided script
./run_gui.sh

# Or manually
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml LMS_UI
```

## Key Concepts Demonstrated

### 1. Object-Oriented Programming
- **Inheritance**: Book and Journal classes inherit from abstract Item class
- **Polymorphism**: Items are treated uniformly through the Item interface
- **Encapsulation**: Private/protected fields with public getters/setters
- **Abstraction**: Abstract Item class defines common structure

### 2. Exception Handling
- **Custom Exceptions**: BookAlreadyBorrowedException with detailed error messages
- **Exception Propagation**: Methods declare throws clauses appropriately
- **Graceful Handling**: Try-catch blocks provide user-friendly error messages
- **Resource Management**: Proper file closure in finally blocks (implicit with try-with-resources pattern)

### 3. File I/O Operations
- **Writing to Files**: Using PrintWriter for catalog export
- **Reading from Files**: Using Scanner for catalog import
- **Error Handling**: FileNotFoundException and general I/O exception handling
- **File Management**: Proper file creation and resource cleanup

### 4. JavaFX GUI Development
- **Application Structure**: Proper JavaFX application lifecycle
- **Layout Management**: GridPane and VBox for organized layouts
- **Event Handling**: Button clicks and form submissions
- **UI Components**: TextArea, TextField, Label, Button usage
- **Interactive Features**: Dynamic content updates and user input validation

## Sample Output

The application demonstrates:
1. Creating and managing library items (books and journals)
2. Borrowing and returning items with exception handling
3. Saving catalog data to files and reading it back
4. Interactive GUI for library management
5. Real-time updates and form validation

## Additional Features

- **Statistics Display**: Shows available vs borrowed items
- **Search Functionality**: Find items by title
- **Input Validation**: Prevents empty form submissions
- **User-Friendly Messages**: Clear feedback for all operations
- **Robust Error Handling**: Graceful handling of all error conditions

## Educational Value

This project serves as a comprehensive example of:
- Advanced Java programming concepts
- Professional software development practices
- GUI application development
- Exception handling strategies
- File I/O best practices
- Object-oriented design principles
