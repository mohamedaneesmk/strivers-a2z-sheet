public class pattern21 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row == 0 || row == N - 1 || col == 0 || col == N - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
