package recursion;

import java.util.Arrays;

class ReverseArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        reverse(0, nums);

        System.out.println(Arrays.toString(nums));
    }

    static void reverse(int i, int[] nums) {
        if (i >= nums.length / 2) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[nums.length - i - 1];
        nums[nums.length - i - 1] = temp;

        reverse(i + 1, nums);
    }
}