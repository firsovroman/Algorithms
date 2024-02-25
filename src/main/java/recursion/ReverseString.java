package recursion;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private static void helper(char [] str, int left, int right) {
        if (left > right) {
            return;
        }
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;

        helper(str, left + 1, right - 1);
    }
}
