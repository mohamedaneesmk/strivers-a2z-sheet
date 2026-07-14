package patterns;
public class pattern16 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {
            char ch = (char) ('A' + row);
            for (int col = 0; col <= row; col++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
