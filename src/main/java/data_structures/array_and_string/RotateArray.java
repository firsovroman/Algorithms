package data_structures.array_and_string;


import java.util.Arrays;

/**
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */


public class RotateArray {

    public static void main(String[] args) {
//        int[] nums = {-1, -100, 3, 99}; // [3,99,-1,-100]
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }


    public static void rotate(int[] nums, int k) {
        // Проверка на пустой массив или некорректное значение k
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }

        // Определение реального количества шагов, чтобы избежать повторений
        k = k % nums.length;

        // Создание временного массива для хранения элементов, которые будут смещены
        int[] temp = Arrays.copyOfRange(nums, nums.length - k, nums.length);

        // Смещение элементов вправо на k шагов
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }


}
