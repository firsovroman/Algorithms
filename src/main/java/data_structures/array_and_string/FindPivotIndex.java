package data_structures.array_and_string;


/**
 * Учитывая массив целых чисел nums, вычислите сводный индекс этого массива.
 * Сводный индекс — это индекс, в котором сумма всех чисел строго слева от индекса равна сумме всех чисел строго справа от индекса.
 * Если индекс находится на левом краю массива, то левая сумма получается 0потому, что слева нет элементов. Это также относится к правому краю массива.
 * Возвращает самый левый сводный индекс . Если такого индекса не существует, верните -1.
 * <p>
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};

        System.out.println(pivotIndex(arr));

    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
