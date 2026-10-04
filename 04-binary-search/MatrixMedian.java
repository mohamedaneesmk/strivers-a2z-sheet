public class MatrixMedian {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 9},
                {2, 5, 6},
                {3, 7, 8}
        };
        System.out.println(matrixMedian(matrix)); // 5

    }

    // Optimal Approach: Binary Search on the answer
    // Since matrix is row-wise sorted, count how many elements are <= mid in each row.
    // Then find the median position in the flattened sorted matrix.
    public static int matrixMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            low = Math.min(low, row[0]);
            high = Math.max(high, row[cols - 1]);
        }

        int target = (rows * cols + 1) / 2; // 1-based median position

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessThanOrEqual(matrix, mid);

            if (count < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int countLessThanOrEqual(int[][] matrix, int value) {
        int count = 0;
        for (int[] row : matrix) {
            count += upperBound(row, value);
        }
        return count;
    }

    private static int upperBound(int[] row, int value) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
