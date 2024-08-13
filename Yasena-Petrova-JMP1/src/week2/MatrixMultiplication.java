package week2;
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] matrix2 = {
                {5, 6},
                {7, 8}
        };
        int[][] result = multiply(matrix1, matrix2);

        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];

        class MultiplierThread extends Thread {
            private int row, col;

            MultiplierThread(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public void run() {
                for (int k = 0; k < col1; k++) {
                    result[row][col] += matrix1[row][k] * matrix2[k][col];
                }
            }
        }

        MultiplierThread[][] threads = new MultiplierThread[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                threads[i][j] = new MultiplierThread(i, j);
                threads[i][j].start();
            }
        }

        try {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    threads[i][j].join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}

