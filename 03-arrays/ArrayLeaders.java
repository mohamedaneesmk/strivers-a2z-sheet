import java.util.ArrayList;
import java.util.List;

public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };

        List<Integer> leaders = findLeaders(arr);
        System.out.println(leaders);
    }

    private static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();

        /*
         * for (int i = 0; i < arr.length; i++) {
         * boolean isLeader = true;
         * 
         * for (int j = i + 1; j < arr.length; j++) {
         * if (arr[j] > arr[i]) {
         * isLeader = false;
         * break;
         * }
         * }
         * 
         * if (isLeader) {
         * leaders.add(arr[i]);
         * }
         * }
         */

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1 || arr[i] > findMax(arr, i + 1, arr.length)) {
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }

    private static int findMax(int[] arr, int start, int length) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i < length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

}
