import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(nums, low, high);

        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low;
        int right = high;

        while (left < right) {

            while (left <= high - 1 && nums[left] <= pivot) {
                left++;
            }

            while (right >= low + 1 && nums[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }

        swap(nums, low, right);

        return right;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
