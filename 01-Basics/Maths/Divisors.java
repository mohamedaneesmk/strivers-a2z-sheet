package Maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {
    public static void main(String[] args) {
        int num = 36;

        List<Integer> divisors = findDivisors(num);
        System.out.println(divisors);
    }

    private static List<Integer> findDivisors(int num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);

                // Avoid adding the square root twice
                if (i != num / i) {
                    divisors.add(num / i);
                }
            }
        }

        Collections.sort(divisors);
        return divisors;
    }
}