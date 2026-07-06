public class pattern11 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("1");
            }
            System.out.println();
        }
    }
}
