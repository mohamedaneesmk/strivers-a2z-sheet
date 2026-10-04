public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        System.out.println(shipWithinDays(weights, days1)); // 15
    }

    // Most optimal approach: Binary Search on answer
    // Search for the minimum valid capacity such that all packages can be shipped in <= days
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            high += w;
            low = Math.max(low, w);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canShip(int[] weights, int capacity, int days) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                usedDays++;
                currentLoad = weight;
                if (usedDays > days) {
                    return false;
                }
            } else {
                currentLoad += weight;
            }
        }

        return true;
    }
}
