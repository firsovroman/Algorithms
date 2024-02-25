package data_structures.arrays.additional_structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Учитывая массив целых чисел, проверьте, существуют ли два индекса i и j такие, что:
 *      i != j
 *      0 <= i, j < arr.length
 *      arr[i] == 2 * arr[j]
 *
 * Example 1:
 *      Input: arr = [10,2,5,3]
 *      Output: true
 *      Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 *
 * Example 2:
 *      Input: arr = [3,1,7,11]
 *      Output: false
 *      Explanation: There is no i and j that satisfy the conditions.
 */

public class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        int[] arr2 = {3, 1, 7, 11};

        System.out.println(checkIfExist(arr));  //true
        System.out.println(checkIfExist(arr2)); //false
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            // Проверяем, существует ли удвоенное значение числа или половина его значения в множестве
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
