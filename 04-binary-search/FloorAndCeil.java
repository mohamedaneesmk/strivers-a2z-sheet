public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 7, 8, 10 };
        int target = 5;

        int floor = getFloor(nums, target);
        int ceil = getCeil(nums, target);

        System.out.println("Floor : " + floor);
        System.out.print("Ceil : " + ceil);
    }

    private static int getCeil(int[] nums, int target) { // the smallest element in the array that is ≥ x.
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int getFloor(int[] nums, int target) { // the largest element in the array that is ≤ x.
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
