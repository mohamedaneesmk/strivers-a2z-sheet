import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        selectionSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap only if needed
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
