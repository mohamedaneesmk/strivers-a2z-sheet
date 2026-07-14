package patterns;
public class pattern11 {
    public static void main(String[] args) {
        int N = 5;
        int start = 1;

        for (int row = 0; row < N; row++) {

            if (row % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }

            for (int col = 0; col <= row; col++) {
                System.out.print(start);
                start = 1 - start;
            }

            System.out.println();
        }
    }
}
