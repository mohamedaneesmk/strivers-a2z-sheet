import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lowerBound = findLowerBound(nums, n, target);

        if (lowerBound == n || nums[lowerBound] != target) {
            return new int[] { -1, -1 };
        }

        return new int[] { lowerBound, findUpperBound(nums, n, target) - 1 };
    }

    private static int findLowerBound(int[] nums, int n, int target) {
        int low = 0, high = nums.length - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int findUpperBound(int[] nums, int n, int target) {
        int low = 0, high = nums.length - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

}
