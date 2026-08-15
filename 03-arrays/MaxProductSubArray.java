public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {

        int n = nums.length;
        int prefix = 1, suffix = 1;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
