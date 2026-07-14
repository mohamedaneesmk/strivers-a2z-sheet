package patterns;
public class pattern19 {
    public static void main(String[] args) {
        int N = 5;

        // Upper half
        for (int row = 0; row < N; row++) {

            for (int col = 0; col <= N - row - 1; col++) {
                System.out.print("*");
            }

            for (int space = 0; space < 2 * row; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col <= N - row - 1; col++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower half
        for (int row = 1; row <= N; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            for (int space = 0; space < 2 * N - (2 * row); space++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
