package Maths;

import java.util.ArrayList;
import java.util.List;

public class GCD {
    public static void main(String[] args) {
        int n1 = 4, n2 = 6;
        System.out.println(findGCD(n1, n2));
    }

    private static int findGCD(int n1, int n2) {

        int gcd = 1;
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i <= n1; i++) {
            if (n1 % i == 0) {
                list1.add(i);
            }
        }

        for (int i = 1; i <= n2; i++) {
            if (n2 % i == 0) {
                list2.add(i);

            }
        }

        // System.out.println(list1);
        // System.out.println(list2);

        for (int num : list1) {
            if (list2.contains(num)) {
                gcd = Math.max(num, gcd);
            }
        }

        return gcd;
    }
}