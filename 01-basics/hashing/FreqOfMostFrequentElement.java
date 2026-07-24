package hashing;

import java.util.Arrays;

public interface FreqOfMostFrequentElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4 };
        int k = 5;
        System.out.println(maxFrequency(arr, k));
    }

    public static long maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);

        int left = 0;
        int windowSum = 0;
        long maxFrequency = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum = windowSum + arr[right];
            long operations = arr[right] * (right - left + 1);

            while (operations - windowSum > k) {
                windowSum = windowSum - arr[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
