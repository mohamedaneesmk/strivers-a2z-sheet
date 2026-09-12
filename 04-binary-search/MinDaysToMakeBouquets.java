
class MinDaysToMakeBouquets {

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }

    private static int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(day, low);
            high = Math.max(day, high);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
            } else {
                bouquets += (flowers / k);
                flowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        bouquets += flowers / k;

        return bouquets >= m;
    }
}
