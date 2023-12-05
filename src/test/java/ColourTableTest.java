import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    @Test
    public void testValidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
        assertDoesNotThrow(() -> new ColourTable(512));
    }

    @Test
    public void testAddColor() {
        ColourTable colourTable = new ColourTable(4);

        // Adding valid color
        assertDoesNotThrow(() -> colourTable.add(255, 0, 0));
        assertEquals(1, colourTable.getSize());

        // Adding another valid color
        assertDoesNotThrow(() -> colourTable.add(0, 255, 0));
        assertEquals(2, colourTable.getSize());

        // Adding invalid color (out of range)
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(256, 0, 0));
        assertEquals(2, colourTable.getSize());
    }

    @Test
    public void testExceedingCapacity() {
        ColourTable colourTable = new ColourTable(2);

        // Adding valid colors
        assertDoesNotThrow(() -> colourTable.add(255, 0, 0));
        assertDoesNotThrow(() -> colourTable.add(0, 255, 0));

        // Exceeding capacity
        assertThrows(IllegalStateException.class, () -> colourTable.add(0, 0, 255));
    }

    @Test
    public void testDuplicateColor() {
        ColourTable colourTable = new ColourTable(4);

        // Adding a color
        assertDoesNotThrow(() -> colourTable.add(255, 0, 0));
        assertEquals(1, colourTable.getSize());

        // Adding the same color again
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(255, 0, 0));
        assertEquals(1, colourTable.getSize());
    }
}
