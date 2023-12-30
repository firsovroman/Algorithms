package Begin.arrays;

import java.util.Arrays;


/**
 Учитывая целочисленный массив фиксированной длины arr, дублируйте каждое вхождение нуля, сдвигая оставшиеся элементы вправо.

 Обратите внимание, что элементы, превышающие длину исходного массива, не записываются.
 Выполните указанные выше изменения во входном массиве.
 на месте и ничего не возвращать.

 Example 1:

 Input: arr = [1,0,2,3,0,4,5,0]
 Output: [1,0,0,2,3,0,0,4]
 Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 Example 2:

 Input: arr = [1,2,3]
 Output: [1,2,3]
 Explanation: After calling your function, the input array is modified to: [1,2,3]
 */

public class DuplicateZeros {


    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 4, 0, 6, 7};

        int[] result = duplicateZerosReturn(nums);
        System.out.println("Первый вариант - " + Arrays.toString(result));

        duplicateZeros(nums);
        System.out.println("Второй вариант - " +Arrays.toString(nums));
    }

    public static void duplicateZeros(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                shiftArray(arr, j);
                j++;
            }
        }
    }

    public static void shiftArray(int[] arr, int from) {
        int cursor = arr.length - 1;
        for (int i = cursor - 1; i >= from; i--) {
            arr[cursor] = arr[i];
            cursor--;
        }
    }




        public static int[] duplicateZerosReturn(int[] arr) {
        int cursor = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; cursor < arr.length; i++) {
            if (arr[i] == 0) {
                temp[cursor] = arr[i];
                temp[++cursor] = arr[i];
            } else {
                temp[cursor] = arr[i];
            }
            cursor++;
        }
        return temp;
    }

}
