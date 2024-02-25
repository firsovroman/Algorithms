package Data_structures.hash_table;

import java.util.LinkedHashMap;
import java.util.Map;

public class JewelsAndStones {

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));

    }


    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : jewels.toCharArray()) {
            map.put(ch, 0);
        }

        for (char ch : stones.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int sum = map.values().stream().reduce(Integer::sum).get();
        return sum;
    }

}
