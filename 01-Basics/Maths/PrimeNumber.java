package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 4;

        System.out.println(checkPrime(num));
    }

    private static boolean checkPrime(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i) {
                    count++;
                }
            }
        }

        return count == 2;
    }
}
