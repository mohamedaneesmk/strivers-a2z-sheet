public class FindPower {
    public static void main(String[] args) {
        double base = 2.00000;
        int n = 10;
        System.out.println(myPow(base, n));
    }

    private static double myPow(double base, int n) {
        long exp = n;
        if (exp < 0)
            return 1.0 / power(base, -exp); // invert only at the end
        return power(base, exp);
    }

    private static double power(double base, long n) {
        if (n == 0)
            return 1.0;
        double half = power(base, n / 2);
        return n % 2 == 0 ? half * half : half * half * base; // multiply by base if n is odd
    }
}