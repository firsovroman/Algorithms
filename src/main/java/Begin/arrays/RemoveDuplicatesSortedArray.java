package Begin.arrays;


import java.util.Arrays;


/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int result = removeDuplicates(arr);

        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {


        int k = 1;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }

        }



        return k;
    }

}
