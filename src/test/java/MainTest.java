import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    public void testCreateTextEditorInstance() {
        TextEditor textEditor = new TextEditor();
        assertNotNull(textEditor);
    }

    @Test
    public void testTextEditorInstanceType() {
        TextEditor textEditor = new TextEditor();
        assertTrue(textEditor instanceof TextEditor);
    }
}