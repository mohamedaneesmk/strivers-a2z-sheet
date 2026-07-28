public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = { 8, 8, 7, 6, 5 };
        System.out.println(secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (secondLargest < num && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
