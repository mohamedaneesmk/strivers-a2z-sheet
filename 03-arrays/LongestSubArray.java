import java.util.HashMap;

public class LongestSubArray {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;

        System.out.println(longestSubarray(nums, k));
    }

    private static int longestSubarray(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // If subarray starts from index 0
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Check if there exists a prefix sum = prefixSum - k
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
