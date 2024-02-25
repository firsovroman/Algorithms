package data_structures.hash_table;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s : strs) {
            char[] chars =  s.toCharArray();
            Arrays.sort(chars);
            String stroka = new String(chars);

            if(anagramGroups.containsKey(stroka)) {
                List<String> list = anagramGroups.get(stroka);
                list.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                anagramGroups.put(stroka,list);
            }
        }

        return new ArrayList<>(anagramGroups.values());
    }

}
