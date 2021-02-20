package edu.berkeley.aep;

// Understands a four-sided figure with sides at right angles
public class Rectangle {
    private final int width;
    private final int height;

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return (2 * width) + (2 * height);
    }
}
