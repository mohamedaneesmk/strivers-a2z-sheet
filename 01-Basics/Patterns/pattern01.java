public class pattern01 {
    public static void main(String[] args) {
        int N = 10;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}