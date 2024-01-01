package Begin.arrays;

import java.util.*;

/**
 * Учитывая целочисленный массив nums, верните третье отдельное максимальное число в этом массиве.
 * Если третий максимум не существует, верните максимальное число.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 * <p>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
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
