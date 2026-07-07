public class pattern12 {
    public static void main(String[] args) {
        int N = 5;
        int temp = 2 * (N - 1);

        for (int row = 1; row <= N; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }

            for (int space = 0; space < temp; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            System.out.println();
            temp = temp - 2;
        }
    }
}
