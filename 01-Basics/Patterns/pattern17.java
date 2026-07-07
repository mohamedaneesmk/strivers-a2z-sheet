public class pattern17 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {

            // Spaces
            for (int space = 0; space < N - row - 1; space++) {
                System.out.print(" ");
            }

            // Increasing characters
            for (int col = 0; col <= row; col++) {
                System.out.print((char) ('A' + col));
            }

            // Decreasing characters
            for (int col = row - 1; col >= 0; col--) {
                System.out.print((char) ('A' + col));
            }

            System.out.println();
        }
    }
}