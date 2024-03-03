package data_structures.array_and_string;

import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {

        String s1 = "anagram", t1 = "nagaram";
        String s2 = "aacc", t2 = "ccac";
        System.out.println(isAnagram(s1, t1)); // true
        System.out.println(isAnagram(s2, t2)); // false
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < s.length(); i++) {
            if(sArr[i] != tArr[i]) {
                return false;
            }
        }

        return true;
    }

}
