class RecursiveBubbleSort {

    public int[] bubbleSort(int[] nums) {
        bubbleSort(nums, nums.length, 0, 0);
        return nums;
    }

    private void bubbleSort(int[] nums, int n, int i, int j) {

        // Outer loop finished
        if (i == n - 1) {
            return;
        }

        // Inner loop finished, start next pass
        if (j == n - i - 1) {
            bubbleSort(nums, n, i + 1, 0);
            return;
        }

        // Compare adjacent elements
        if (nums[j] > nums[j + 1]) {
            int temp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = temp;
        }

        // Continue current pass
        bubbleSort(nums, n, i, j + 1);
    }
}