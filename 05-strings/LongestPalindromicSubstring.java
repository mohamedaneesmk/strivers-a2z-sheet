class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String string = "babad";

        System.out.println(longestPalindrome(string));
    }

    private static String longestPalindrome(String string) {

        // Handle null or empty string
        if (string == null || string.length() < 1) {
            return "";
        }

        int length = string.length();

        // Starting index of the longest palindrome
        int start = 0;

        // Minimum palindrome length is 1
        int maxLen = 1;

        // Try every character as the center
        for (int i = 0; i < length; i++) {

            // Odd-length palindrome
            // Example: "aba"
            int len1 = expand(string, i, i);

            // Even-length palindrome
            // Example: "abba"
            int len2 = expand(string, i, i + 1);

            // Take the longer palindrome
            int len = Math.max(len1, len2);

            // Update answer if we found a longer palindrome
            if (len > maxLen) {

                maxLen = len;

                // Calculate starting index
                start = i - (len - 1) / 2;
            }
        }

        // Return the longest palindrome
        return string.substring(start, start + maxLen);
    }

    private static int expand(String string, int left, int right) {

        // Expand while characters are equal
        while (left >= 0
                && right < string.length()
                && string.charAt(left) == string.charAt(right)) {

            left--;
            right++;
        }

        // left and right are now one position outside
        // the actual palindrome
        return right - left - 1;
    }
}
