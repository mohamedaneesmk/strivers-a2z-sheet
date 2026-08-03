// import java.util.HashMap;
// import java.util.Map;

public class MajorityElement1 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        /*
         * Map<Integer, Integer> map = new HashMap<>();
         * 
         * for (int num : nums) {
         * map.put(num, map.getOrDefault(num, 0) + 1);
         * 
         * if (map.get(num) > nums.length / 2) {
         * return num;
         * }
         * }
         * 
         * return -1;
         */

        // Moore's Voting Algorithm

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > nums.length / 2) ? candidate : -1;
    }
}
