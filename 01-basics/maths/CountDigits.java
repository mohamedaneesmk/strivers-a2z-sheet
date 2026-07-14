package maths;

public class CountDigits {
    public static void main(String[] args) {
        int num = 234;

        System.out.println(findCount(num));
    }

    private static int findCount(int num) {
        int count = 0;

        while (num != 0) {
            count++;
            num = num / 10;
        }

        return count;
    }
}
