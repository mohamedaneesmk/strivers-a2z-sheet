package backtracking;

public class PrintNto1 {
    public static void main(String[] args) {
        int num = 5;
        backtracking(1, num);
    }

    private static void backtracking(int i, int num) {
        if (num < i)
            return;

        backtracking(i + 1, num);
        System.out.println(i);
    }
}
