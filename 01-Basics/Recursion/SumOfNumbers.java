public class SumOfNumbers {

    public static void main(String[] args) {
        int N = 4;
        System.out.print(sumofNumbers(N));
    }

    private static int sumofNumbers(int n) {
        if(n == 0) return 0;
        return n + sumofNumbers(n - 1);
    }
}
