public class pattern10 {
    public static void main(String[] args) {
        int N = 5;

        // Upper half
        for (int row = 1; row <= N; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int row = N - 1; row >= 1; row--) {
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}