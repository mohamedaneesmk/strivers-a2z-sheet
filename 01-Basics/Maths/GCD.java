package maths;

public class GCD {
    public static void main(String[] args) {
        int n1 = 4, n2 = 6;
        System.out.println(findGCD(n1, n2));
    }

    private static int findGCD(int n1, int n2) {

        /*
         * int gcd = 1;
         * 
         * for (int i = Math.min(n1, n2); i >= 1; i--) {
         * if (n1 % i == 0 && n2 % i == 0) {
         * gcd = i;
         * break;
         * }
         * }
         * 
         * return gcd;
         */

        // Euclidean Algorithm
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2)
                n1 = n1 % n2;
            else
                n2 = n2 % n1;
        }

        if (n1 == 0)
            return n2;
        return n1;
    }
}