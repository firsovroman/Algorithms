package Begin.hash_table;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k)); // true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // false

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                int resultIndex = Math.abs(i - j);
                if (resultIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
