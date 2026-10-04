public class KthElementOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        System.out.println(kthElement(a, b, 5)); // 6

        int[] c = {100, 112, 256, 349, 770};
        int[] d = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(kthElement(c, d, 7)); // 256
    }

    private static int kthElement(int[] a, int[] b, int k) {
        // Always binary search on the smaller array for optimal time complexity
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - b.length);
        int high = Math.min(a.length, k);

        while (low <= high) {
            int partitionA = low + (high - low) / 2;
            int partitionB = k - partitionA;

            int leftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int rightA = (partitionA == a.length) ? Integer.MAX_VALUE : a[partitionA];
            int leftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int rightB = (partitionB == b.length) ? Integer.MAX_VALUE : b[partitionB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("k is out of range for the given arrays");
    }
}
