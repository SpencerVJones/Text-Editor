# Text Editor
  <div align="left">
	
![Repo Views](https://visitor-badge.laobi.icu/badge?page_id=SpencerVJones/Text-Editor)
</div>
This project is a Swing-based text editor developed in Java. The Swing Text Editor provides a simple yet functional graphical user interface for creating, editing, and saving text files. With features like changing font size and style, adjusting text and background color, and basic text manipulation options (such as copy, paste, and cut), it offers a user-friendly experience for working with text documents.

## Key Features:
- **Intuitive GUI:** The text editor features a clean and intuitive graphical user interface, making it easy for users to navigate and perform various text editing tasks.
- **Text Area:** Provides a text area for editing text with functionalities like word wrapping and scroll bars.
- **Font Customization:** Allows users to change the font size and font family of the text.
- **Text Formatting:** Supports text formatting options such as bold and italic.
- **Text Color and Background Color:** Enables users to customize the text color and background color.
- **Case Conversion:** Provides options to convert text to uppercase or lowercase.
- **File Operations:** Supports file operations including opening, saving, copying, cutting, and pasting text.
- **Menu Bar:** Includes a menu bar with options for file and edit operations.

## Usage:
- **Download/Clone the Repository:** Clone or download the repository to your local machine using Git or GitHub's download feature.
- **Compile the Java Code:** Compile the Java source files using your preferred Java compiler or IDE.
- **Run the Text Editor:** Run the Main class to launch the Swing Text Editor application.
- **Explore the Features:** Explore the various features of the text editor, such as font customization, color options, and file operations.
- **Create/Edit Text Files:** Use the text editor to create new text files, open existing files, and edit text content as needed.
- **Save Changes:** Save any changes made to text files using the "Save" menu option.
- **Exit the Application:** Exit the text editor application by selecting the "Exit" menu option or closing the application window.

## Folder Structure
- `Main.java`: Contains the main class to start the text editor application.
- `TextEditor.java`: Implements the text editor functionality.
- `MainTest.java`: Contains unit tests for the Main class.
- `TextEditorTest.java`: Contains unit tests for the TextEditor class.


## Testing:
The Swing Text Editor project is accompanied by a robust suite of unit tests designed to ensure the reliability, functionality, and usability of the application. These tests cover a wide range of features, including GUI elements, text manipulation capabilities, file operations, and user interactions.

### Key Testing Categories:
- **GUI Component Testing:** Verifies the correct initialization and behavior of GUI components such as the text area (pad), font size spinner (textSizeSpinner), font combo box (fontBox), and various buttons for text formatting.
- **Text Manipulation Testing:** Ensures that the application accurately handles text manipulation tasks such as changing font styles (bold, italic), converting text case (uppercase, lowercase), and adjusting text colors and background colors.
- **File Operations Testing:** Validates the functionality of file-related operations, including opening, saving, copying, pasting, and cutting text within the editor, as well as interacting with external text files.
- **Menu Item Testing:** Tests the behavior of menu items such as creating a new instance of the text editor, opening and saving text files, exiting the application, and performing copy, paste, and cut operations via the menu bar.

### Comprehensive Test Coverage:
The test suite is designed to cover various use cases and edge cases to ensure the application's stability and correctness under different scenarios. Each test case targets specific functionalities and user interactions, providing comprehensive coverage of the Swing Text Editor's capabilities.

### Continuous Validation:
The tests are regularly executed as part of the development process to validate new features, bug fixes, and enhancements. Continuous integration and automated testing pipelines help maintain the quality and reliability of the application over time.

## Technologies and Design Patterns Used:
- **Java:** Programming language for developing the application.
- **Java Swing:** Java's GUI toolkit used for building the application's graphical interface, offering components like JTextArea, JMenuBar, and JButtons for user interaction.
- **Model-View-Controller (MVC) Architecture:** Adopts the MVC pattern to separate concerns and maintain a clean codebase. The model handles data and logic, the view manages the GUI components, and the controller orchestrates user interactions.
- **Singleton Pattern:** Utilizes the Singleton pattern for certain components like JColorChooser and JFileChooser to ensure a single instance throughout the application.
- **Observer Pattern:** Implements the Observer pattern for components like JSpinner to observe and react to changes in the font size.
- **JUnit 5:** Employs JUnit 5 for unit testing, ensuring the reliability and correctness of the application's functionalities.
- **IDE:** IntelliJ IDEA Ultimate


## Contributing
Contributions are welcome! 

### You can contribute by:
-  Reporting bugs
-  Suggesting new features
-  Submitting pull requests to improve the codebase
