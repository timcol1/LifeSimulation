package avlyakulov.timur.simulation.game;

public class TestSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        System.out.println(matrix.length);//длинна строки
        System.out.println(matrix[0].length);//длина столбца
        int iPosition = 2;
        int jPosition = 2;

        matrix[iPosition][jPosition] = 1;


        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
