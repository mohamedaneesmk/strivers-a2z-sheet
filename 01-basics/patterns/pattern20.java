package patterns;
public class pattern20 {
    public static void main(String[] args) {

        int N = 5;

        // Upper half
        for (int row = 0; row < N; row++) {

            // Left stars
            for (int col = 0; col <= row; col++)
                System.out.print("*");

            // Spaces
            for (int space = 0; space < 2 * (N - row - 1); space++)
                System.out.print(" ");

            // Right stars
            for (int col = 0; col <= row; col++)
                System.out.print("*");

            System.out.println();
        }

        // Lower half
        for (int row = N - 2; row >= 0; row--) {

            // Left stars
            for (int col = 0; col <= row; col++)
                System.out.print("*");

            // Spaces
            for (int space = 0; space < 2 * (N - row - 1); space++)
                System.out.print(" ");

            // Right stars
            for (int col = 0; col <= row; col++)
                System.out.print("*");

            System.out.println();
        }
    }
}