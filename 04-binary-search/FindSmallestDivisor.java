
class FindSmallestDivisor {

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;

        System.out.println(smallestDivisor(nums, threshold));
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (findSum(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int findSum(int[] nums, int mid) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += (num + mid - 1) / mid;
        }

        return totalSum;
    }
}
