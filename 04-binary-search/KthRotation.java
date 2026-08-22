public class KthRotation {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 2, 3, 4 };
        System.out.println(findKRotation(arr));
    }

    private static int findKRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}