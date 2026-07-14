package patterns;
public class pattern05 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = N; row >= 0; row--) {
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
