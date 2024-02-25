package Data_structures.hash_table;

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t)); //true

        String s1 = "badc", t2 = "baba";
        System.out.println(isIsomorphic(s1, t2)); //false
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (!sMap.get(sChar).equals(tChar)) {
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
            }

            if (tMap.containsKey(tChar)) {
                if (!tMap.get(tChar).equals(sChar)) {
                    return false;
                }
            } else {
                tMap.put(tChar, sChar);
            }

        }

        return true;
    }
}
