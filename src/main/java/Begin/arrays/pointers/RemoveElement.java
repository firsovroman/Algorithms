package Begin.arrays.pointers;


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

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int val = 2;

        int result = removeElement(arr, val);

        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }


    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                shiftElement(nums, i);
                count++;
            }
        }

        return nums.length - count;
    }


    public static void shiftElement(int[] intArray, int indexForDelete) {
        for (int i = indexForDelete; i < intArray.length - 1; i++) {
            intArray[i] = intArray[i + 1];
        }
        intArray[intArray.length - 1] = 0;
    }


}
