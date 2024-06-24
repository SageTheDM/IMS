public class App {
    public static void main(String[] args) throws Exception {
        int[] numbersForMath = new int[3];
        numbersForMath[0] = 24;
        numbersForMath[1] = 56;
        int sum = calcSum(numbersForMath[0], numbersForMath[1]);
        System.out.println(sum);
        System.out.println(numbersForMath[2]);
    }

    public static int calcSum(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
