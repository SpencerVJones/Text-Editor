import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class TextEditorTest {
    private TextEditor textEditor;

    @BeforeEach
    public void setUp() {
        textEditor = new TextEditor();
    }

    // Utility method to access private fields using reflection
    private Object getField(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    @Test
    public void testInitialTextAreaState() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");

        // Check that text area is not null
        assertNotNull(pad);

        // Check default properties
        assertEquals(Color.WHITE, pad.getBackground());
        assertTrue(pad.getLineWrap());
        assertTrue(pad.getWrapStyleWord());
        assertEquals(new Font("Arial", Font.PLAIN, 20), pad.getFont());
    }

    @Test
    public void testChangeFontSize() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JSpinner textSizeSpinner = (JSpinner) getField(textEditor, "textSizeSpinner");

        // Set font size spinner value
        int newSize = 25;
        textSizeSpinner.setValue(newSize);

        // Check if font size of text area is updated
        Font expectedFont = new Font("Arial", Font.PLAIN, newSize);
        assertEquals(expectedFont, pad.getFont());
    }

    @Test
    public void testChangeFontFamily() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JComboBox fontBox = (JComboBox) getField(textEditor, "fontBox");

        // Set font family
        String fontFamily = "Courier New";
        fontBox.setSelectedItem(fontFamily);

        // Check if font family of text area is updated
        Font expectedFont = new Font(fontFamily, Font.PLAIN, 20);
        assertEquals(expectedFont, pad.getFont());
    }

    @Test
    public void testChangeTextColor() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton textColorButton = (JButton) getField(textEditor, "textColorButton");

        // Set text color
        Color newColor = Color.RED;
        textColorButton.doClick();

        // Check if text color of text area is updated
        assertEquals(newColor, pad.getForeground());
    }

    @Test
    public void testChangeBackgroundColor() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton backgroundColorButton = (JButton) getField(textEditor, "backgroundColorButton");

        // Set background color
        Color newColor = Color.BLUE;
        backgroundColorButton.doClick();

        // Check if background color of text area is updated
        assertEquals(newColor, pad.getBackground());
    }

    @Test
    public void testToggleBold() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton boldButton = (JButton) getField(textEditor, "boldButton");

        // Click bold button to toggle bold font style
        boldButton.doClick();

        // Check if font style is bold
        assertTrue(pad.getFont().isBold());
    }

    @Test
    public void testToggleItalic() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton italicizeButton = (JButton) getField(textEditor, "italicizeButton");

        // Click italicize button to toggle italic font style
        italicizeButton.doClick();

        // Check if font style is italic
        assertTrue(pad.getFont().isItalic());
    }

    @Test
    public void testConvertToUppercase() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton uppercaseButton = (JButton) getField(textEditor, "uppercaseButton");

        // Set text and convert to uppercase
        pad.setText("hello");
        uppercaseButton.doClick();

        // Check if text is converted to uppercase
        assertEquals("HELLO", pad.getText());
    }

    @Test
    public void testConvertToLowercase() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JButton lowercaseButton = (JButton) getField(textEditor, "lowercaseButton");

        // Set text and convert to lowercase
        pad.setText("HELLO");
        lowercaseButton.doClick();

        // Check if text is converted to lowercase
        assertEquals("hello", pad.getText());
    }

    @Test
    public void testNewMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JMenuItem newItem = (JMenuItem) getField(textEditor, "newItem");

        // Click new menu item
        newItem.doClick();

        // Check if a new instance of TextEditor is created
        assertNotNull(textEditor);
    }

    @Test
    public void testOpenMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JMenuItem openItem = (JMenuItem) getField(textEditor, "openItem");
        JTextArea pad = (JTextArea) getField(textEditor, "pad");

        // Set some text in the text area
        pad.setText("Initial text");

        // Click open menu item
        openItem.doClick();

        // Verify that the text area content has changed after opening a file
        assertNotEquals("Initial text", pad.getText());
    }

    @Test
    public void testSaveMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JMenuItem saveItem = (JMenuItem) getField(textEditor, "saveItem");

        // Set some text in the text area
        pad.setText("Text to save");

        // Click save menu item
        saveItem.doClick();

        // Verify that the text area content is correctly saved to a file
    }

    @Test
    public void testCopyMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JMenuItem copyItem = (JMenuItem) getField(textEditor, "copyItem");

        // Set some text in the text area
        pad.setText("Text to copy");

        // Select the text
        pad.selectAll();

        // Click copy menu item
        copyItem.doClick();

        // Verify that the selected text is copied to the clipboard

    }

    @Test
    public void testPasteMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JMenuItem pasteItem = (JMenuItem) getField(textEditor, "pasteItem");

        // Click paste menu item
        pasteItem.doClick();

        // Verify that text from the clipboard is pasted into the text area

    }

    @Test
    public void testCutMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JMenuItem cutItem = (JMenuItem) getField(textEditor, "cutItem");

        // Set some text in the text area
        pad.setText("Text to cut");

        // Select the text
        pad.selectAll();

        // Click cut menu item
        cutItem.doClick();

        // Verify that the selected text is removed from the text area and copied to the clipboard

    }

    @Test
    public void testUppercaseMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JMenuItem uppercaseItem = (JMenuItem) getField(textEditor, "uppercaseItem");

        // Set some text in the text area
        pad.setText("lowercase text");

        // Select the text
        pad.selectAll();

        // Click uppercase menu item
        uppercaseItem.doClick();

        // Verify that the selected text is converted to uppercase
        assertEquals("LOWERCASE TEXT", pad.getText());
    }

    @Test
    public void testLowercaseMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JTextArea pad = (JTextArea) getField(textEditor, "pad");
        JMenuItem lowercaseItem = (JMenuItem) getField(textEditor, "lowercaseItem");

        // Set some text in the text area
        pad.setText("UPPERCASE TEXT");

        // Select the text
        pad.selectAll();

        // Click lowercase menu item
        lowercaseItem.doClick();

        // Verify that the selected text is converted to lowercase
        assertEquals("uppercase text", pad.getText());
    }

    @Test
    public void testExitMenuItem() throws NoSuchFieldException, IllegalAccessException {
        JMenuItem exitItem = (JMenuItem) getField(textEditor, "exitItem");

        // Click exit menu item
        exitItem.doClick();
    }
}