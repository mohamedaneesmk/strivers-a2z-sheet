package patterns;
public class pattern07 {
    public static void main(String[] args) {
        int N = 10;

        for (int row = 0; row < N; row++) {

            for (int space = 0; space < N - row - 1; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("*");
            }

            for (int space = 0; space < N - row - 1; space++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
