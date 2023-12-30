package Begin.arrays;

import java.util.Arrays;

/**
 * Учитывая целочисленный массив nums, переместите все 0элементы в конец, сохраняя относительный порядок ненулевых элементов.
 * Обратите внимание , что вы должны сделать это на месте, не копируя массив.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
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
