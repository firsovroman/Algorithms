package data_structures.arrays;


/**
 * Дан массив nums целых чисел. Определите, сколько из них содержат четное количество цифр.
 *
 * Пример 1:
 *      Ввод: nums = [12,345,2,6,7896]
 *      Вывод: 2
 *      Объяснение:
 *          12 содержит 2 цифры (чётное количество цифр).
 *          Число 345 содержит 3 цифры (нечетное количество цифр).
 *          2 содержит 1 цифру (нечетное количество цифр).
 *          6 содержит 1 цифру (нечетное количество цифр).
 *          Число 7896 содержит 4 цифры (четное количество цифр).
 *          Следовательно, только 12 и 7896 содержат четное количество цифр.
 */
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }


    public static int findNumbers(int[] arr) {
        int count = 0;
        for(Integer num : arr) {
            if(isEven(num)) {
                count++;
            }
        }
        return count;
    }


    public static boolean isEven(int num) {
        return (String.valueOf(num).length() % 2) == 0 ;
    }

}
