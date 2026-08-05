import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {

        int n = nums.length;
        int pivot = -1;

        // Find Pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot, reverse entire array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find next greater element
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Reverse suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
