import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] strength = new int[5];

        strength[0] = 5;
        strength[1] = 12;
        strength[2] = 18;
        strength[3] = 2;
        strength[4] = 1;

        for (int i = 0; i < strength.length; i++) {
            System.out.println(strength[i]);
        }
        System.out.println("-------------------------------------");
        Arrays.sort(strength);

        for (int i = 0; i < strength.length; i++) {
            System.out.println(strength[i]);
        }
    }
}
