package maths;

public class ReverseTheNumber {
    public static void main(String[] args) {
        int num = 123;

        System.out.println(reverse(num));
    }

    private static int reverse(int num) {
        int result = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            result = (result * 10) + lastDigit;
            num = num / 10;
        }

        return result;
    }
}
