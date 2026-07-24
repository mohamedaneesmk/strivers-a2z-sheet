import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Insert key at the correct position
            nums[j + 1] = key;
        }
    }
}