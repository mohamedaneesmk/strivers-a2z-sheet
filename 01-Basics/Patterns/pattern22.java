public class pattern22 {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 0; row < 2 * n - 1; row++) {
            for (int col = 0; col < 2 * n - 1; col++) {
                int top = row;
                int left = col;
                int right = (2 * n - 2) - col;
                int bottom = (2 * n - 2) - row;
 
                System.out.print(n - Math.min(Math.min(top, bottom), Math.min(left, right)) + " ");
            }
            System.out.println();
        }
    }
}
 