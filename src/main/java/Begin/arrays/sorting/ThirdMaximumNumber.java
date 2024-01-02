package Begin.arrays.sorting;

import java.util.*;

/**
 * Учитывая целочисленный массив nums, верните третье отдельное максимальное число в этом массиве.
 * Если третий максимум не существует, верните максимальное число.
 *
 * Example 1:
 *      Input: nums = [3,2,1]
 *      Output: 1
 *      Explanation:
 *      The first distinct maximum is 3.
 *      The second distinct maximum is 2.
 *      The third distinct maximum is 1.
 */

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,2,5,3,5};
        System.out.println(thirdMax(arr));
    }


    public static int thirdMax(int[] nums) {
        int[] uniqArr = Arrays.stream(nums).sorted().distinct().toArray();


        if (uniqArr.length < 3) {
            return Arrays.stream(uniqArr).max().orElse(0);
        } else {
            return uniqArr[uniqArr.length - 3];
        }
    }
}
