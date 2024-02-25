package Data_structures.hash_table;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println(singleNumber(nums1)); // Вывод: 1
        System.out.println(singleNumber(nums2)); // Вывод: 4
        System.out.println(singleNumber(nums3)); // Вывод: 1
    }


    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            Integer i = map.get(num);
            if(i != null) {
                map.put(num, ++i);
            } else {
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet() ) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }


// XOR
//    public static int singleNumber(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            result ^= num;
//        }
//        return result;
//    }

}
