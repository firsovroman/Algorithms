package math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static void main(String[] args) {

        System.out.println(selfDividingNumbers(47, 85)); // 48,55,66,77

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();


        for (int i = left; i <= right; i++) {
            if (isDiving(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean isDiving(int number) {
        int temp = number;

        while (temp > 0) {
            int cif = temp % 10;
            if (cif == 0 || number % cif != 0) {
                return false;
            }
            temp = temp / 10;
        }

        return true;
    }
}
