public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s1)); // 3

        String s2 = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s2)); // 3

        String s3 = "()(())((()()))";
        System.out.println(maxDepth(s3)); // 3
    }

    // Optimal solution: O(n) time, O(1) extra space
    public static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (ch == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}
