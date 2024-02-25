package data_structures.array_and_string;

/**
 * Вам дан целочисленный массив nums, в котором наибольшее целое число уникально.
 * Определите, больше ли самый большой элемент массива хотя бы в два раза больше любого другого числа в массиве.
 * Если это так, верните индекс наибольшего элемента или верните -1 противном случае .
 * <p>
 * Пример 1:
 * Ввод: nums = [3,6,1,0]
 * Вывод: 1
 * Объяснение: 6 — самое большое целое число.
 * Для любого другого числа в массиве x 6 как минимум в два раза больше x.
 * Индекс значения 6 равен 1, поэтому мы возвращаем 1.
 */

public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
//        int[] arr = {3, 6, 1, 0};
        int[] arr = {1, 2, 3, 4};

        System.out.println(dominantIndex(arr));
    }

    public static int dominantIndex(int[] nums) {
        int max = nums[0];
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int n : nums) {
            if (n != max && max < 2 * n) {
                return -1;
            }
        }

        return maxIndex;
    }

}
