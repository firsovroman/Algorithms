package Data_structures.hash_table;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num1 : nums1) {
            set1.add(num1);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int num2 : nums2) {
            set2.add(num2);
        }

        List<Integer> list = new ArrayList<>();
        for(Integer i : set1){
            if(!set2.add(i)){
                list.add(i);
            }
        }

        int[] arr = new int[list.size()];
        for(int it = 0; it < arr.length; it++) {
            arr[it] = list.get(it);
        }

        return arr;
    }

}
