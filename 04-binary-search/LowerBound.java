public class LowerBound {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 };
        int x = 2;

        System.out.println(lowerBound(nums, x));
    }

    private static int lowerBound(int[] nums, int x) {
        int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}