package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }


    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] arr = s.toCharArray();
        int sum = 0;
        int prevValue = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int curValue = map.get(arr[i]);
            if (curValue < prevValue) {
                sum -= curValue;
            } else  {
                sum += curValue;
            }
            prevValue = curValue;
        }
        return sum;
    }

}
