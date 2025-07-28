# Assignment Summary: Advanced Java Library Management System

## Completed Requirements

### ✅ Question 1: Exception Handling (20 Points)
**File:** `librarySystem/BookAlreadyBorrowedException.java`

- **Custom Exception Class**: Created `BookAlreadyBorrowedException` with meaningful error messages
- **Exception Usage**: Implemented in `Librarian.checkOutBorrowedItem(Item item)` method  
- **Key Features**:
  - Uses `super()` constructor for message handling
  - Overrides `getMessage()` and `toString()` methods
  - Proper `throw` and `throws` implementation
  - Try-catch blocks for graceful error handling

**Code Demonstration:**
```java
// Custom exception with detailed error messages
public class BookAlreadyBorrowedException extends Exception {
    // Throws exception when item already borrowed
    public void checkOutBorrowedItem(Item item, String borrowerName) throws BookAlreadyBorrowedException
    // Try-catch usage in safeCheckOut method
}
```

### ✅ Question 2: File I/O Operations (20 Points)  
**File:** `librarySystem/Librarian.java`

- **Save Method**: `saveCatalogToFile(String filename)` - writes catalog to file using PrintWriter
- **Read Method**: `readCatalogFromFile(String filename)` - reads catalog using Scanner
- **Error Handling**: Proper FileNotFoundException and general exception handling
- **File Operations**: Demonstrates file creation, writing, reading, and resource cleanup

**Code Demonstration:**
```java
// File I/O with proper exception handling
public void saveCatalogToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new File(filename))) {
        // Write library information and catalog items
    } catch (FileNotFoundException e) {
        System.err.println("Error: Could not create or write to file " + filename);
    }
}
```

### ✅ Question 3: JavaFX GUI (10 Points)
**File:** `LMS_UI.java`

- **Application Structure**: Extends `javafx.application.Application`
- **GUI Components**: Uses TextArea, Labels, GridPane layout
- **Information Display**: Shows librarian name, library name, location, catalog size
- **Proper Setup**: Implements `start(Stage stage)` method and main method with `launch(args)`

### ✅ Bonus: Interactive GUI (20 Points)
**Enhanced Features in:** `LMS_UI.java`

- **Interactive Forms**: TextFields and Labels for user input
- **Event Handling**: Button with `setOnAction(e -> {...})` implementation  
- **Dynamic Updates**: Real-time updates using `TextArea.appendText()`
- **Input Validation**: Proper form validation and error alerts
- **User Experience**: Professional interface with clear feedback

## Technical Implementation

### Object-Oriented Design
```
Item (Abstract Base Class)
├── Book (Concrete Implementation)
└── Journal (Concrete Implementation)

Library (Collection Management)
Librarian (Business Logic)
BookAlreadyBorrowedException (Custom Exception)
```

### Exception Handling Flow
1. **Custom Exception**: `BookAlreadyBorrowedException` with detailed error messages
2. **Exception Throwing**: `checkOutBorrowedItem()` throws exception when item already borrowed
3. **Exception Catching**: `safeCheckOut()` method handles exceptions gracefully
4. **User Feedback**: Clear error messages displayed to users

### File I/O Operations
1. **Save Catalog**: Exports library information and all items to text file
2. **Read Catalog**: Imports and displays catalog information from file
3. **Error Handling**: Handles file not found and other I/O exceptions
4. **Resource Management**: Proper file closure and resource cleanup

### JavaFX GUI Features
1. **Basic Display**: Shows library information in TextArea
2. **Interactive Forms**: Input fields for librarian name, library details
3. **Event Handling**: Submit button updates library information dynamically
4. **Professional Layout**: GridPane organization with proper spacing and alignment
5. **Input Validation**: Prevents empty submissions with alert dialogs

## Files Created

### Core Library System (`librarySystem/` package):
- `Item.java` - Abstract base class for library items
- `Book.java` - Book implementation with ISBN and pages
- `Journal.java` - Journal implementation with ISSN, volume, issue
- `Library.java` - Library management with item collection
- `Librarian.java` - Business logic with File I/O and exception handling
- `BookAlreadyBorrowedException.java` - Custom exception class

### Applications:
- `LMS_UI.java` - JavaFX GUI application with interactive features
- `LibraryTest.java` - Console application demonstrating all features

### Documentation and Utilities:
- `README.md` - Comprehensive project documentation
- `run_gui.sh` - Script to run JavaFX application
- `.gitignore` - Proper Java project gitignore
- `LibrarySystem.zip` - Complete project archive

## Compilation and Execution

### Basic Compilation:
```bash
javac librarySystem/*.java LibraryTest.java
```

### JavaFX Compilation:
```bash
javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml LMS_UI.java
```

### Run Console App:
```bash
java LibraryTest
```

### Run GUI App:
```bash
./run_gui.sh
# OR
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml LMS_UI
```

## Assignment Deliverables

✅ **ZIP File**: `LibrarySystem.zip` containing complete project
✅ **All Required Classes**: Item, Book, Journal, Library, Librarian, Exception
✅ **Exception Handling**: Custom exception with proper usage
✅ **File I/O**: Save and read catalog functionality
✅ **JavaFX GUI**: Basic and interactive features implemented
✅ **Documentation**: Comprehensive README and code comments

## Key Learning Outcomes Demonstrated

1. **Advanced OOP**: Inheritance, polymorphism, abstraction, encapsulation
2. **Exception Handling**: Custom exceptions, try-catch, throws declarations
3. **File I/O**: PrintWriter, Scanner, FileNotFoundException handling
4. **GUI Development**: JavaFX application structure, event handling, layouts
5. **Software Engineering**: Project organization, documentation, testing
