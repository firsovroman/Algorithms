package data_structures.hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k))); // [1, 2]

        int[] nums2 = {1,2};
        System.out.println(Arrays.toString(topKFrequent(nums2, k))); // [1, 2]
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = map.keySet().stream().sorted((a, b) -> map.get(b) - map.get(a)).toList();

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
