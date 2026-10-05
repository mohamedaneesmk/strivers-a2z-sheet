public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters solution =
                new NumberOfSubstringsContainingAllThreeCharacters();
        System.out.println(solution.numberOfSubstrings("abcabc"));
        System.out.println(solution.numberOfSubstrings("aaacb"));
        System.out.println(solution.numberOfSubstrings("abc"));
    }

    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            last[s.charAt(j) - 'a'] = j;
            count += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }

        return count;
    }
}
