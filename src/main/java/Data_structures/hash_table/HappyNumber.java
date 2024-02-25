package Data_structures.hash_table;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int number1 = 19;
        System.out.println("Число " + number1 + " является счастливым: " + isHappy(number1));

        int number2 = 2;
        System.out.println("Число " + number2 + " является счастливым: " + isHappy(number2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = calc(n);
        }
        return n == 1;
    }

    public static int calc(int n) {
        int sum = 0;
        while (n != 0) {
            int dig = n % 10;
            sum += dig * dig;
            n = n / 10;
        }
        return sum;
    }

}
