package patterns;
public class pattern13 {
    public static void main(String[] args) {
        int N = 5;
        int count = 1;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }
}
