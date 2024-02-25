package data_structures.arrays.pointers;


import java.util.Arrays;


/**
 * Учитывая целочисленный массив nums и целочисленное значение, удалите все вхождения val в nums на месте.
 * Порядок элементов может быть изменен. Затем верните количество элементов в виде чисел, которые не равны val.
 *
 * Пример 1:
 *      Ввод: nums = [3,2,2,3], val = 3
 *      Выход: 2, числа = [2,2,_,_]
 *
 * Пример 2:
 *      Ввод: nums = [0,1,2,2,3,0,4,2], значение = 2
 *      Выход: 5, числа = [0,1,4,0,3,_,_,_]
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
