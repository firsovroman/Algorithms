package Begin.arrays;


import java.util.*;

/**
 * Учитывая массив numsцелых nчисел где nums[i]находится в диапазоне [1, n],
 * верните массив всех целых чисел в диапазоне [1, n] , которые не входят в nums диапазон .
 * <p>
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 */

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
//        int[] arr = {1,1};


        System.out.println(findDisappearedNumbers(arr));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Отмечаем числа в массиве как отрицательные на основе их индексов
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Определить пропущенные положительные числа в массиве (индексы + 1)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        List<Integer> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        for(int i = 1 ; i <= nums.length; i++) {
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }


}
