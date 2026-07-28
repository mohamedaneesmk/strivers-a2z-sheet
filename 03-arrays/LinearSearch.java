public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 3 };
        int target = 3;

        System.out.println(linearSearch(arr, target));
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
