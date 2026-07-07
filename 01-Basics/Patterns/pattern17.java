public class pattern17 {
    public static void main(String[] args) {
        int N = 5;

        for (int row = 0; row < N; row++) {

            // Spaces
            for (int space = 0; space < N - row - 1; space++) {
                System.out.print(" ");
            }

            // Characters
            char ch = 'A';
            int breakpoint = (2 * row + 1) / 2;

            for (int col = 1; col <= 2 * row + 1; col++) {
                System.out.print(ch);
                if (col <= breakpoint)
                    ch++;
                else
                    ch--;
            }

            System.out.println();
        }
    }
}