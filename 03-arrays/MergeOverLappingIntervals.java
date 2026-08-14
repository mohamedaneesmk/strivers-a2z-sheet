import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {
    public static void main(String[] args) {
        int[][] nums = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };

        int[][] result = mergeOverlappingIntervals(nums);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    private static int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
