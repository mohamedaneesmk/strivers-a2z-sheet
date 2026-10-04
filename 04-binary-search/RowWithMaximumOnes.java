public class RowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        int rowIndex = findRowWithMaximumOnes(matrix);
        if (rowIndex != -1) {
            System.out.println("Row with maximum number of 1s: " + rowIndex);
        } else {
            System.out.println("No row with 1s found.");
        }
    }

    private static int findRowWithMaximumOnes(int[][] matrix) {
        int maxRowIndex = -1;
        int maxOnesCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            int onesCount = countOnesInRow(matrix[i]);
            if (onesCount > maxOnesCount) {
                maxOnesCount = onesCount;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

    private static int countOnesInRow(int[] is) {
        int count = 0;
        for (int num : is) {
            if (num == 1) {
                count++;
            }
        }
        return count;
    }
}
