
public class MedianOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedian(nums1, nums2)); // 2.0
    }

    private static double findMedian(int[] nums1, int[] nums2) {
        // Always binary search on the SMALLER array -> guarantees O(log(min(m,n)))
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;
        int halfLen = (m + n + 1) / 2; // left half size (works for both odd/even total)

        while (low <= high) {
            int cut1 = (low + high) / 2;      // partition point in nums1
            int cut2 = halfLen - cut1;        // partition point in nums2

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                // correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1; // move partition left in nums1
            } else {
                low = cut1 + 1;  // move partition right in nums1
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
}
