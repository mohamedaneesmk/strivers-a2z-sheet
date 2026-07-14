package maths;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 4;

        System.out.println(checkPrime(num));
    }

    private static boolean checkPrime(int num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
