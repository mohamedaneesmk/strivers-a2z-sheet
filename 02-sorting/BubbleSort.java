import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
