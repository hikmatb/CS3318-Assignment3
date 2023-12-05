package org.example;

public class ColourTable {

    int paletteSize;
    int[][] colors;
    int size;

    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }

        this.paletteSize = paletteSize;
        this.colors = new int[paletteSize][3]; // RGB values stored in a 2D array
        this.size = 0;
    }

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

    public int getSize() {
        return size;
    }

    private boolean isValidPaletteSize(int size) {
        return size > 1 && size < 1025 && (size & (size - 1)) == 0; // Check if it's a power of two
    }

    private boolean isColorValueValid(int value) {
        return value >= 0 && value <= 255;
    }

    private boolean containsColor(int red, int green, int blue) {
        for (int i = 0; i < size; i++) {
            if (colors[i][0] == red && colors[i][1] == green && colors[i][2] == blue) {
                return true; // Duplicate color found
            }
        }
        return false;
    }
}
