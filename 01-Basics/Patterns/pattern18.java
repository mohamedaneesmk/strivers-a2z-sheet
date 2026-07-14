package patterns;
public class pattern18 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {
            for (char ch = (char) ('E' - row); ch <= 'E'; ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
