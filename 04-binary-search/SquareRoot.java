
public class SquareRoot {

    public static void main(String[] args) {
        int num = 28;
        System.out.println(findSqaureRoot(num));
    }

    private static int findSqaureRoot(int num) {
        if (num == 0) {
            return 0;
        }

        long low = 1, high = num;
        long ans = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sq = mid * mid;

            if (sq <= num) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }
}
