public class MaximumOnes {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1}
        };

        System.out.println(rowWithMax1s(matrix));
    }

    private static int rowWithMax1s(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxCount = 0;
        int rowIndex = -1;

        for (int row = 0; row < n; row++) {
            int firstOneIndex = lowerBound(matrix[row], 1);
            int countOf1 = (firstOneIndex == -1) ? 0 : m - firstOneIndex;

            if (countOf1 > maxCount) {
                maxCount = countOf1;
                rowIndex = row;
            }
        }

        return rowIndex;
    }

    // Returns index of first occurrence of 'target' in sorted array, or -1 if not found
    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}