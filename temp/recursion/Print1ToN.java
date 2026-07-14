package recursion;

public class Print1ToN {
    public static void main(String[] args) {
        int N = 5;
        print(N);
    }

    private static void print(int N) {
        if (N == 0)
            return;

        print(N - 1);
        System.out.println(N);
    }
}