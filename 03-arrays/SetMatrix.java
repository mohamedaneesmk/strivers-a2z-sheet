public class SetMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };

        setZeroes(matrix);

        printMatrix(matrix);
    }

    // OPTIMAL SOLUTION
    private static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firstColZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * BETTER SOLUTION
     * private static void setZeroes(int[][] matrix) {
     * int[] row = new int[matrix.length];
     * int[] col = new int[matrix[0].length];
     * 
     * for (int i = 0; i < matrix.length; i++) {
     * for (int j = 0; j < matrix[0].length; j++) {
     * if (matrix[i][j] == 0) {
     * row[i] = 1;
     * col[j] = 1;
     * }
     * }
     * }
     * 
     * for (int i = 0; i < matrix.length; i++) {
     * for (int j = 0; j < matrix[0].length; j++) {
     * if (row[i] == 1 || col[j] == 1) {
     * matrix[i][j] = 0;
     * }
     * }
     * }
     * }
     */
}