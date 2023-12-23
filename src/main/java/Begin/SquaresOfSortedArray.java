package Begin;

import java.util.Arrays;

/**
 * Учитывая целочисленный массив nums, отсортированный в неубывающем порядке, верните массив квадратов каждого числа , отсортированный в неубывающем порядке .
 *
 * Пример 1:
 * Ввод: nums = [-4,-1,0,3,10]
 *  Выход: [0,1,9,16,100]
 *  Объяснение: После возведения в квадрат массив становится [16,1,0,9,100].
 * После сортировки оно становится [0,1,9,16,100].
 *
 * Пример 2:
 * Ввод: числа = [-7,-3,2,3,11]
 *  Выход: [4,9,9,49,121]
 */

public class SquaresOfSortedArray {


    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            nums[i] = (current * current);
        }
        Arrays.sort(nums);
        return nums;
    }


}
