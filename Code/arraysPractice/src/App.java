public class App {
    public static void main(String[] args) throws Exception {
        double[] arr = new double[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0.1;
        }

        String student[] = { "Gianna", "Niki", "Luca", "Yasin", "Andi", "Beis", "Stipe", "Patrick", "Andrin", "Yasin" };
        System.out.println("The class has: " + student.length + " students");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 4.12;
            arr[i] = arr[i] + i;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = 0; i < student.length; i++) {
            System.out.println("Student with the index " + i + " is called: " + student[i]);
        }
    }
}
