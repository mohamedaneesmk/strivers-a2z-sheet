import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 1 };
        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
