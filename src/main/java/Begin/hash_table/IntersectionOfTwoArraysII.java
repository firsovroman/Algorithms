package Begin.hash_table;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2))); // 2, 2


        int[] nums11 = {4, 9, 5};
        int[] nums22 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums11, nums22))); // [4,9]

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.getOrDefault(i, 1) + 1);
                continue;
            }
            map1.put(i, 1);
        }

        List<Integer> result = new ArrayList<>();


        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            list.add(i);
        }

        for(int j : list) {
            if(map1.containsKey(j)) {
                int count = map1.get(j);
                if(count > 0) {
                    result.add(j);
                    count--;
                    map1.put(j, count);
                }
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
