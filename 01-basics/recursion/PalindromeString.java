package recursion;

public class PalindromeString {
    public static void main(String[] args) {
        String string = "anees";
        System.out.println(checkPalindrome(string, 0));
    }

    private static boolean checkPalindrome(String string, int i) {
        if (i >= string.length() / 2)
            return true;

        if (string.charAt(i) != string.charAt(string.length() - i - 1))
            return false;

        return checkPalindrome(string, i + 1);
    }
}
