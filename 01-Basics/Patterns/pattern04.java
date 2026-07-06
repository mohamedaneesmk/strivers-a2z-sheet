public class pattern04 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
