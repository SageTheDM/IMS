public class App {
    public static void main(String[] args) throws Exception {

        Circle myCircleOne = createCircle(11, 222, 3);
        Circle myCircleTwo = createCircle(11, 222, 3);
        Circle myCircleThree = createCircle(11, 222, 3);

        printCircle(myCircleOne, "Circle one");
        printCircle(myCircleTwo, "Circle two");
        printCircle(myCircleThree, "Circle three");
    }

    private static void printCircle(Circle circle, String name) {
        System.out.println(name + ": ");
        System.out.println("Coordinates: " + "(" + circle.point.x + "/" + circle.point.y + ")");
        System.out.println("Radius: " + circle.radius);
        System.out.println("");

    }

    private static Circle createCircle(int x, int y, int radius) {
        Circle circle = new Circle();

        circle.point.x = x;
        circle.point.y = y;
        circle.radius = radius;

        return circle;
    }
}
