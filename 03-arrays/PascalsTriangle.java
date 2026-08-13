import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        System.out.println(result);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {

            List<Integer> current = new ArrayList<>();

            long val = 1;

            for (int col = 0; col <= row; col++) {
                current.add((int) val);
                val = val * (row - col) / (col + 1);
            }

            pascal.add(current);
        }

        return pascal;
    }
}
