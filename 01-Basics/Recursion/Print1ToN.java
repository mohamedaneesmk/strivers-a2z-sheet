package Recursion;

public class Print1ToN {
    public static void main(String[] args) {
        int N = 5;
        print(1, N);
    }

    private static void print(int i, int N) {
        if (i > N)
            return;
        System.out.println(i);
        print(i + 1, N);
    }
}
