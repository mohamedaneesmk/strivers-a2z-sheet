import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        List<Integer> result = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                result.add(nums[left]);
                left++;
            } else {
                result.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            result.add(nums[left]);
            left++;
        }

        while (right <= high) {
            result.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = result.get(i - low);
        }
    }
}
