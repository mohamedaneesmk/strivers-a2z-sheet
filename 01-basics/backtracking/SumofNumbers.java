package backtracking;

public class SumofNumbers {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(sumofNumbers(num));
    }

    private static int sumofNumbers(int num) {
        if (num == 0)
            return 0;
        return num + sumofNumbers(num - 1);
    }
}
