import java.util.HashMap;

public class LongestSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLength(nums));
    }

    private static int maxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            if (sum == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(sum)) {

                int prevIndex = map.get(sum);

                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
