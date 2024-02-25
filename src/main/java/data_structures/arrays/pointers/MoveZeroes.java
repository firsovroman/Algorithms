package data_structures.arrays.pointers;

import java.util.Arrays;

/**
 * Учитывая целочисленный массив nums, переместите все 0элементы в конец, сохраняя относительный порядок ненулевых элементов.
 * Обратите внимание , что вы должны сделать это на месте, не копируя массив.
 *
 * Example 1:
 *      Input: nums = [0,1,0,3,12]
 *      Output: [1,3,12,0,0]
 *      Example 2:
 */

public class MoveZeroes {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void moveZeroes(int[] nums) {
        int cursor = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[cursor] = nums[i];
                cursor++;
            }
        }

        while (cursor <= nums.length - 1) {
            nums[cursor] = 0;
            cursor++;
        }

    }
}
