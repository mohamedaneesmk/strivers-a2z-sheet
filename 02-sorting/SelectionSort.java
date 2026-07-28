import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        selectionSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            // Swap
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
