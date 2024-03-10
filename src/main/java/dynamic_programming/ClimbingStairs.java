package dynamic_programming;

import java.util.LinkedList;
import java.util.Queue;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));

    }

    public static int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            if(i % 2 == 0) {
                b = sum;
            } else {
                a = sum;
            }
        }

        return sum;
    }

}
