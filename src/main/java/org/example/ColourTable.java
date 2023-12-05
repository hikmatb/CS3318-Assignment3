package org.example;

public class ColourTable {

    int paletteSize;
    int[][] colors;
    int size;

    /**
     * The ColourTable function is used to create a ColourTable object.
     *
     * @param paletteSize Set the size of the 2d array colors
     *
     */
    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }

        this.paletteSize = paletteSize;
        this.colors = new int[paletteSize][3]; // RGB values stored in a 2D array
        this.size = 0;
    }

    /**
     * The add function adds a color to the ColourTable.
     *
     * @param red Store the red value of a color
     * @param green Store the green value of a color
     * @param blue Store the blue value of a color
     *
     *
     */
    public void add(int red, int green, int blue) {
        if (!isColorValueValid(red) || !isColorValueValid(green) || !isColorValueValid(blue)) {
            throw new IllegalArgumentException("Invalid color values");
        }

        if (size >= paletteSize) {
            throw new IllegalStateException("Exceeding the capacity of the ColourTable");
        }

        // Check for duplicate color
        if (containsColor(red, green, blue)) {
            throw new IllegalArgumentException("Duplicate color");
        }

        // Add the color to the array
        colors[size][0] = red;
        colors[size][1] = green;
        colors[size][2] = blue;
        size++;
    }

    /**
     * The getSize function returns the size of the array.
     *
     * @return The size of the stack
     *
     */
    public int getSize() {
        return size;
    }

    /**
     * The isValidPaletteSize function checks if the given size is a valid palette size.
     * A valid palette size must be greater than 1 and less than 1025, and it must also be a power of two.
     *
     * @param size Check if the size is a power of two
     *
     * @return True if the palette size is between 2 and 1024, inclusive
     *
     */
    private boolean isValidPaletteSize(int size) {
        return size > 1 && size < 1025 && (size & (size - 1)) == 0; // Check if it's a power of two
    }

    /**
     * The isColorValueValid function checks to see if the value passed in is a valid color value.
     *
     *
     * @param value Determine whether the value is between 0 and 255
     *
     * @return A boolean value
     *
     */
    private boolean isColorValueValid(int value) {
        return value >= 0 && value <= 255;
    }

    /**
     * The containsColor function checks to see if the color is already in the array.
     *
     *
     * @param red Check if the red value of a color is already in the array
     * @param green Check if the green value of a color is already in the colors array
     * @param blue Check if the color blue is in the array
     *
     * @return True if the color is already in the palette
     *
     */
    private boolean containsColor(int red, int green, int blue) {
        for (int i = 0; i < size; i++) {
            if (colors[i][0] == red && colors[i][1] == green && colors[i][2] == blue) {
                return true; // Duplicate color found
            }
        }
        return false;
    }
}
