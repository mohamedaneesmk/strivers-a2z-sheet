import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        moveZeros(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr) {
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
    }
}
