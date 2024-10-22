public class Rectangle {
    // Private attributes for length and width
    private double length;
    private double width;

    // Constructor with two parameters to initialize the length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Setter methods
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setSides(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getter methods
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Method to get the longer side
    public double getLongerSide() {
        return Math.max(length, width);
    }

    // Method to get the shorter side
    public double getShorterSide() {
        return Math.min(length, width);
    }

    // Method to calculate the diagonal of the rectangle
    public double getDiagonal() {
        return Math.sqrt(length * length + width * width);
    }

    // Method to calculate the area of the rectangle
    public double getArea() {
        return length * width;
    }

    // Method to calculate the perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Methods to adjust length and width
    public void increaseLength(double l) {
        length += l;
    }

    public void increaseWidth(double w) {
        width += w;
    }

    public void decreaseLength(double l) {
        length -= l;
        if (length < 0)
            length = 0; // Ensure length doesn't become negative
    }

    public void decreaseWidth(double w) {
        width -= w;
        if (width < 0)
            width = 0; // Ensure width doesn't become negative
    }
}
