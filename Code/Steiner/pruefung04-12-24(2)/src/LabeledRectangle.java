//Luca Fbian Burger
// Aufgabe 5

import java.awt.Rectangle;

public class LabeledRectangle extends Rectangle {
    private String label;

    LabeledRectangle(int x, int y, int width, int height, String label) {
        super(x, y, width, height);
        this.label = label;
    }

    public String getInfo() {
        return "Label: " + this.label + "\nPosition: (" + this.x + ", " + this.y + ")" + "\nGrösse: " + this.width + "x"
                + this.height;
    }
}
