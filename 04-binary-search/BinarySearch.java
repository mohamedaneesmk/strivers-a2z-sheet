public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
