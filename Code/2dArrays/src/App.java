public class App {

    public static void main(String[] args) {
        int[][] matrix1 = {
                // x 0 1 2
                { 1, 2, 3 }, // 0
                { 4, 5, 6 }, // 1
                { 7, 8, 9 } // 2 y
        };

        int[][] matrix2 = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        System.out.println(matrix1[1][2]);
        System.out.println(matrix2[1][2]);

        int[][] sumMatrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                sumMatrix[j][i] = matrix1[j][i] + matrix2[j][i];
            }
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}