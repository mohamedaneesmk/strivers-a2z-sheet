import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {

        int length = nums.length - 1;

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
