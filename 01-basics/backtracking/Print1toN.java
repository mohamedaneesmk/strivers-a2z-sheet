package backtracking;

public class Print1toN {
    public static void main(String[] args) {
        int num = 5;
        backtracking(num);
    }

    private static void backtracking(int num) {
        if (num < 1)
            return;

        backtracking(num - 1);
        System.out.println(num);
    }
}
