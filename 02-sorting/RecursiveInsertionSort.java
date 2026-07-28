class RecursiveInsertionSort  {

    public int[] insertionSort(int[] nums) {
        insertionSort(nums, 1);
        return nums;
    }

    private void insertionSort(int[] nums, int index) {

        // Base case
        if (index == nums.length) {
            return;
        }

        int key = nums[index];

        // Insert key into the sorted part
        insert(nums, index - 1, key);

        // Sort the remaining elements
        insertionSort(nums, index + 1);
    }

    private void insert(int[] nums, int j, int key) {

        // Correct position found
        if (j < 0 || nums[j] <= key) {
            nums[j + 1] = key;
            return;
        }

        // Shift element to the right
        nums[j + 1] = nums[j];

        // Continue moving left
        insert(nums, j - 1, key);
    }
}