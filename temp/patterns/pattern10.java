package patterns;
public class pattern10 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 1; row <= 2 * N - 1; row++) {
            int stars = row;

            if (row > N) {
                stars = 2 * N - row;
            }

            for (int col = 1; col <= stars; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}