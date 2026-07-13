package Maths;

public class Palindrome {
    public static void main(String[] args) {
        int num = 321;

        System.out.println(isPalindrome(num));
    }

    private static boolean isPalindrome(int num) {
        int result = 0;
        int originalNum = num;

        while (num != 0) {
            int lastDigit = num % 10;
            result = (result * 10) + lastDigit;
            num = num / 10;
        }

        return result == originalNum;
    }

}
