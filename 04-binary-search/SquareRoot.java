public class SquareRoot {
    public static void main(String[] args) {
        int num = 28;
        System.out.println(findSqaureRoot(num));
    }

    private static int findSqaureRoot(int num) {
        if (num < 2) return num;
        
        int low = 1, high = num / 2, ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= num / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
