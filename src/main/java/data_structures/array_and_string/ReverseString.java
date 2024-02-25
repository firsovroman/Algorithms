package data_structures.array_and_string;

import java.util.Arrays;

public class ReverseString {


    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int k = 0;
        int m = s.length - 1;

        while (k < m) {
            char temp = s[k];
            s[k] = s[m];
            s[m] = temp;
            k++;
            m--;
        }
    }
}
