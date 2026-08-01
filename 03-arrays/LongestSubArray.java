public class LongestSubArray {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;

        System.out.println(longestSubarray(nums, k));
    }

    private static int longestSubarray(int[] nums, int key) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];

                if (key == sum) {
                    max = Math.max(max, j - i + 1);
                }
            }

        }

        return max;
    }
}
