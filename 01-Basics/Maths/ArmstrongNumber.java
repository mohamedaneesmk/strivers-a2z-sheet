package maths;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 370;

        System.out.println(isArmstrong(num));
    }

    private static boolean isArmstrong(int num) {
        int sum = 0;
        int temp = num;

        int digits = countDigits(num);

        while (num != 0) {
            int lastDigit = num % 10;
            sum = sum + power(lastDigit, digits);
            num = num / 10;
        }

        return temp == sum;
    }

    private static int power(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }

        return result;
    }

    private static int countDigits(int num) {
        int count = 0;

        while (num > 0) {
            count++;
            num = num / 10;
        }

        return count;
    }

}
