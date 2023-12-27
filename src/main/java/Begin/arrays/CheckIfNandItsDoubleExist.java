package Begin.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * Example 2:
 * <p>
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 */

public class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {

        int[] arr = {10, 2, 5, 3};
        int[] arr2 = {3, 1, 7, 11};
        int[] arr3 = {-10, 12, -20, -8, 15};
        int[] arr4 = {0, 0};
        int[] arr5 = {-20, 8, -6, -14, 0, -19, 14, 4};

        System.out.println(checkIfExist2(arr));  //true
//        System.out.println(checkIfExist(arr2)); //false
//        System.out.println(checkIfExist(arr3)); //true
//        System.out.println(checkIfExist(arr4)); //true
//        System.out.println(checkIfExist(arr5)); //true


    }

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == 2 * arr[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static boolean checkIfExist2(int[] arr) {
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
