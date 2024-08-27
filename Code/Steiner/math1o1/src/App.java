public class App {
    public static void main(String[] args) throws Exception {
        int result = 0;

        for (int numberOne = 0; numberOne <= 10; numberOne++) {
            for (int numberTwo = 0; numberTwo <= 10; numberTwo++) {
                result = numberOne * numberTwo;
                System.out.println(numberOne + " times " + numberTwo + " : " + result);
            }
            System.out.println();
        }
    }
}
