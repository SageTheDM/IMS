public class App {
    public static void main(String[] args) throws Exception {
        int smallNumber = 3;
        int bigNumber = 27;
        int sum = 0;

        for (int i = smallNumber; i <= bigNumber; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
