package Begin.arrays;


import java.util.Arrays;


/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 *
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 */

public class RemoveElement2 {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

//        int[] arr = {3, 2, 2, 3};
//        int val = 2;

        int result = removeElement(arr, val);

        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }


    public static int removeElement(int[] nums, int val) {
        int cursor = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cursor++] = nums[i];
            }
        }

        for(int i = cursor; i < nums.length; i++) {
            nums[i] = 0;
        }

        return cursor;
    }



}
