public class NumberOfSubstringCount {
    public static void main(String[] args) {
        String str = "aba";
        System.out.println("Number of substrings: " + countSubstrings(str));
    }

    private static long countSubstrings(String str) {
        int n = str.length();
        long count = 0;

        // Count odd length palindromic substrings
        for (int center = 0; center < n; center++) {
            int left = center, right = center;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        // Count even length palindromic substrings
        for (int center = 0; center < n - 1; center++) {
            int left = center, right = center + 1;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
