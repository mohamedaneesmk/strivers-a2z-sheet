import java.util.Arrays;

public class ReArrangeElements {
    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };

        int[] ans = rearrangeArray(nums);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}