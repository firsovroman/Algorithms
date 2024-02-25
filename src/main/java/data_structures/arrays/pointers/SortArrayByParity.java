package data_structures.arrays.pointers;


import java.util.Arrays;

/**
 * Учитывая целочисленный массив nums, переместите все четные целые числа в начало массива, а затем все нечетные целые числа.
 * Возвращает любой массив , удовлетворяющий этому условию .
 *
 * Example 1:
 *      Input: nums = [3,1,2,4]
 *      Output: [2,4,3,1]
 *      Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *      Example 2:
 */

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0) {
                left++;
            }

            if (nums[right] % 2 != 0) {
                right--;
            }
        }

        return nums;
    }

}
