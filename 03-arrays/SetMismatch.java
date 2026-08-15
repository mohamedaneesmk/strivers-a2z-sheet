import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 6, 7, 5, 7 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    private static int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] count = new int[n + 1];
        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            count[num]++;
            if (count[num] == 2) {
                duplicate = num;
            }
        }

        for (int i = 1; i < n; i++) {
            if (count[i] == 0) {
                missing = i;
                break;
            }
        }

        return new int[] { duplicate, missing };
    }
}
