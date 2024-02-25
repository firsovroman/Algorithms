package data_structures.arrays;

import java.util.Arrays;

/**
 * Учитывая массив arr, замените каждый элемент в этом массиве наибольшим элементом
 * среди элементов справа от него и замените последний элемент на -1.
 * После этого верните массив.
 *
 * Пример 1:
 *      Ввод: arr = [17,18,5,4,6,1]
 *      Выход: [18,6,6,6,1,-1]
 */

public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1}; // output 18,6,6,6,1,-1
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = (arr.length - 1); i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }

}
