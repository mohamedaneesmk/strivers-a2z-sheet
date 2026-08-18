import java.util.Arrays;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 7, 8, 10 };
        int target = 5;

        System.out.println(Arrays.toString(getFloorAndCeil(nums, target)));
    }

    private static int[] getFloorAndCeil(int[] nums, int target) {

        int floor = -1;
        int ceil = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return new int[] { target, target };
            } else if (nums[mid] < target) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                ceil = nums[mid];
                high = mid - 1;
            }
        }

        return new int[] { floor, ceil };
    }
}
