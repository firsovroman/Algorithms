package data_structures.hash_table;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        String s0 = " ";
        System.out.println(lengthOfLongestSubstring(s0)); // 1

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // 3

        String s4 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s4)); // 3

    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);

            if (map.containsKey(curChar)) {
                start = Math.max(start, map.get(curChar) + 1);
            }

            map.put(curChar, end);
            result = Math.max(result, end - start + 1);
        }
        return result;
    }


}
