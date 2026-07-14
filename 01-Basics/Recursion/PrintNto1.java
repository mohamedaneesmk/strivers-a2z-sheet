package Recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        int N = 5;
        print(1, N);
    }

    private static void print(int i, int N) {
        if (N < 1)
            return;
        System.out.println(N);
        print(i, N - 1);
    }
}
