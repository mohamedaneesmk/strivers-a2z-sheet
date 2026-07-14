package recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        int N = 5;
        print(N, N);
    }

    private static void print(int i, int N) {
        if (i < 1)
            return;

        System.out.println(i);
        print(i - 1, N);
    }
}