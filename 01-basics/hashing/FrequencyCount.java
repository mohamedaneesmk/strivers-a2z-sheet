package hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 3 };

        Map<Integer, Integer> map = frequencyCount(nums);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static Map<Integer, Integer> frequencyCount(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }
}