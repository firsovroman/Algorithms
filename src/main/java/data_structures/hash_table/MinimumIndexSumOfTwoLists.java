package data_structures.hash_table;

import java.util.*;

public class MinimumIndexSumOfTwoLists {


    public static void main(String[] args) {

        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int index = entry.getValue();
                int index2 = map2.get(entry.getKey());
                result.put(entry.getKey(), index + index2);
            }
        }

        List<Map.Entry<String, Integer>> sorted = result.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        List<String> list = new ArrayList<>();
        int min = sorted.get(0).getValue();
        for (Map.Entry<String, Integer> ent : sorted) {
            if (ent.getValue() <= min) {
                list.add(ent.getKey());
            }
        }

        return list.toArray(new String[0]);
    }
}
