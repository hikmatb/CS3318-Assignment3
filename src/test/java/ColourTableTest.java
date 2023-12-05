import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    /**
     * The testValidPaletteSize function tests the ColourTable constructor to ensure that it throws an IllegalArgumentException when passed a palette size of 0, 1, or 1025.
     * It also ensures that the constructor does not throw an exception when passed a valid palette size (2, 4, 8 or 512).
     */
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

    /**
     * The testAddColor function tests the add function in ColourTable.java
     * The testAddColor function checks if a valid color is added to the colour table, and if an invalid color is not added to the colour table.
     */
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

    /**
     * The testExceedingCapacity function tests the add function in ColourTable.java to ensure that it throws an
     * IllegalStateException when a colour is added to a table with no more space left.
     */
    @Test
    public void testExceedingCapacity() {
        ColourTable colourTable = new ColourTable(2);

        // Adding valid colors
        assertDoesNotThrow(() -> colourTable.add(255, 0, 0));
        assertDoesNotThrow(() -> colourTable.add(0, 255, 0));

        // Exceeding capacity
        assertThrows(IllegalStateException.class, () -> colourTable.add(0, 0, 255));
    }

    /**
     * The testDuplicateColor function tests the add function in ColourTable.java to ensure that it throws an
     * IllegalArgumentException when a duplicate colour is added to the table. The testDuplicateColor function first
     * creates a new ColourTable object with 4 colours, then adds one colour (255, 0, 0) and checks that the size of
     * the table is 1. Then it attempts to add another colour (255, 0, 0) and checks that an IllegalArgumentException is thrown
     * and also ensures that there are still only 1 colours in the table after attempting to add a duplicate value. This test case passes if
     */
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
