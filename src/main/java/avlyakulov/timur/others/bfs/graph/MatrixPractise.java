package avlyakulov.timur.others.bfs.graph;

public class MatrixPractise {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[2][2] = 1;
        printMatrix(matrix);
    }
}
