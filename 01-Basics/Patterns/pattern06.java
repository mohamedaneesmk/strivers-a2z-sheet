public class pattern06 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = N; row > 0; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}