public class App {
    public static int findNumber(int numberOfNumbers, String startSequenz) {
        int counter = 0;
        int i = Integer.parseInt(startSequenz);
        while (true) {
            if (String.valueOf(i).startsWith(startSequenz)) {
                counter++;
                if (counter == numberOfNumbers) {
                    return i;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNumber(12, "253"));
        System.out.println(findNumber(1000, "9876"));
    }
}
