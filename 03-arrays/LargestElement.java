public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { -4, -3, 0, 1, -8 };
        System.out.println(findLargest(arr));
    }

    private static int findLargest(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}
