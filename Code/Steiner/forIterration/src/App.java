public class App {
    public static void main(String[] args) throws Exception {
        int minute = 0;
        boolean under10 = false;

        for (int hour = 0; hour <= 23; minute++) {

            if (minute == 60) {
                minute = 0;
                hour++;
            }

            switch (hour) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                    under10 = true;
                    break;

                default:
                    break;
            }

            if (under10) {
                if (minute < 10) {
                    System.out.println("0" + hour + ":" + "0" + minute);
                } else {
                    System.out.println(hour + ":" + minute);
                }
            } else {
                if (minute < 10) {
                    System.out.println(hour + ":" + "0" + minute);
                } else {
                    System.out.println(hour + ":" + minute);
                }
            }
        }
        System.out.println("End of Code");
    }
}
