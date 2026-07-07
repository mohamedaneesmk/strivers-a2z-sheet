public class pattern15 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {
            for (char ch = 'A'; ch < 'A' + (N - row); ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
