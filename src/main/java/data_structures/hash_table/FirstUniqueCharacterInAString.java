package data_structures.hash_table;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));

        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2));

        String s3 = "aabb";
        System.out.println(firstUniqChar(s3));

    }


    public static int firstUniqChar(String s) {
        Map<Character, Integer> hashmap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashmap.containsKey(ch)) {
                int sum = hashmap.get(ch) + 1;
                hashmap.put(ch, sum);
                continue;
            }
            hashmap.put(ch, 1);
        }

        for (int j = 0; j < s.length(); j++) {
            if (hashmap.get(s.charAt(j)).equals(1)) {
                return j;
            }
        }

        return -1;
    }

}
