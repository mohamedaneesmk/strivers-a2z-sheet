package recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        int N = 5;
        print(N);
    }

    private static void print(int N) {
        if (N < 1)
            return;

        System.out.println(N);
        print(N - 1);
    }
}