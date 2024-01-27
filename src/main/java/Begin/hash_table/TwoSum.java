package Begin.hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 15, 11, 7}; // [0, 1]
        System.out.println(Arrays.toString(twoSum(arr, 9)));

        int[] arr2 = {3, 3}; // [0, 1]
        System.out.println(Arrays.toString(twoSum(arr2, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if(map.containsKey(dif)) {
                int indexPrev = map.get(dif);
                return new int[] {indexPrev, i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
