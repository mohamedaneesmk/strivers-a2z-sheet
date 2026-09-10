
class NthRootOfInteger {

    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(NthRoot(n, m));
    }

    private static int NthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            long power = calculatePower(mid, n, m);

            if (power == m) {
                return mid;
            } else if (power < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static long calculatePower(int base, int exponent, int limit) {
        long ans = 1;

        for (int i = 0; i < exponent; i++) {
            ans = ans * base;
            if (ans > limit) {
                return ans;
            }
        }

        return ans;
    }

}
