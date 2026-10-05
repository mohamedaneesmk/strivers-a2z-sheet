public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int[] oddRadii = new int[n];
        int[] evenRadii = new int[n];
        int bestStart = 0;
        int bestLength = 1;
        int left = 0;
        int right = -1;

        for (int i = 0; i < n; i++) {
            int radius = i > right
                    ? 1
                    : Math.min(oddRadii[left + right - i], right - i + 1);

            while (i - radius >= 0 && i + radius < n
                    && s.charAt(i - radius) == s.charAt(i + radius)) {
                radius++;
            }
            oddRadii[i] = radius;

            int length = 2 * radius - 1;
            if (length > bestLength) {
                bestStart = i - radius + 1;
                bestLength = length;
            }

            if (i + radius - 1 > right) {
                left = i - radius + 1;
                right = i + radius - 1;
            }
        }

        left = 0;
        right = -1;
        for (int i = 0; i < n; i++) {
            int radius = i > right
                    ? 0
                    : Math.min(evenRadii[left + right - i + 1], right - i + 1);

            while (i - radius - 1 >= 0 && i + radius < n
                    && s.charAt(i - radius - 1) == s.charAt(i + radius)) {
                radius++;
            }
            evenRadii[i] = radius;

            int length = 2 * radius;
            if (length > bestLength) {
                bestStart = i - radius;
                bestLength = length;
            }

            if (i + radius - 1 > right) {
                left = i - radius;
                right = i + radius - 1;
            }
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}
