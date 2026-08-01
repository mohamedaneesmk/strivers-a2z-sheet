public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 1, 4 };
        System.out.println(findMissingNumber(nums));
    }

    private static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        return n * (n + 1) / 2 - totalSum;
    }
}