package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(findFibonacci(n));
    }

    private static int findFibonacci(int n) {
        if (n <= 1)
            return n;

        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

        /*
         * Using Recursion
         * if(n <= 1) return n;
         * return findFibonacci(n - 1) + findFibonacci(n - 2);
         */
    }
}
