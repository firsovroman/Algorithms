package data_structures.array_and_string;

import java.util.HashSet;
import java.util.Set;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            set.add(ch);
        }

        for(char ch : t.toCharArray()) {
            if(!set.contains(ch)) {
                return false;
            }
        }
        return true;
    }

}
