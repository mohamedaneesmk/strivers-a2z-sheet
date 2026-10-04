public class RemoveOutermostParanthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    private static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else if (c == ')') {
                openCount--;
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
        
}
