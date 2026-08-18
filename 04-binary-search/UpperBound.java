public class UpperBound {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 8, 15, 19 };
        int x = 9;

        System.out.println(upperBound(nums, x));
    }

    private static int upperBound(int[] nums, int x) {
        int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

}
