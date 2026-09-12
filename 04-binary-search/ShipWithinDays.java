
public class ShipWithinDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    private static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalSum = 0;

        for (int weight : weights) {
            maxWeight = Math.max(weight, maxWeight);
            totalSum += weight;
        }

        int low = maxWeight, high = totalSum;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysRequired = findDaysRequired(weights, mid);
            if (daysRequired <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int findDaysRequired(int[] weights, int capacity) {
        int days = 1, load = 0;

        for (int weight : weights) {
            if (load + weight > capacity) {
                days = days + 1;
                load = weight;
            } else {
                load += weight;
            }
        }

        return days;
    }
}
