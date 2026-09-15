
import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;

        System.out.println(aggressiveCows(stalls, cows));
    }

    public static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canWePlace(stalls, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean canWePlace(int[] stalls, int distance, int cows) {
        int cowsCount = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - last >= distance) {
                cowsCount++;
                last = stalls[i];
            }

            if (cowsCount >= cows) {
                return true;
            }
        }

        return false;
    }
}
