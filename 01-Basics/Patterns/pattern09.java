public class pattern09 {
    public static void main(String[] args) {
        int N = 10;

        for (int row = 0; row < N; row++) {

            for (int space = 0; space < N - row - 1; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int row = 1; row < N; row++) {

            for (int space = 0; space < row; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < 2 * N - (2 * row + 1); col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
