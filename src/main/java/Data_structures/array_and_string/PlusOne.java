package Data_structures.array_and_string;


import java.util.Arrays;

/**
 * Вам дано большое целое число, представленное в виде массива целых чисел digits,
 * каждое из которых digits[i] является цифрой целого числа. Цифры упорядочены от наиболее значимого к наименее значимому,
 * слева направо.
 * Большое целое число не содержит ведущих символов.ith0
 * Увеличьте большое целое число на единицу и верните результирующий массив цифр.
 * <p>
 * Пример 1:
 * Ввод: цифры = [1,2,3]
 * Выход: [1,2,4]
 * Объяснение: Массив представляет целое число 123.
 * Увеличение на единицу дает 123 + 1 = 124.
 * Таким образом, результат должен быть [1,2,4].
 */

public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {9, 9, 9}; // 1000
//        int[] arr = {1, 2, 3}; // 124
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int k = digits.length - 1;
        digits[k] += 1;
        while (k >= 0 && digits[k] == 10) {
            digits[k] = 0;
            if (k == 0) {
                int[] arrNew = new int[digits.length + 1];
                arrNew[0] = 1;
                System.arraycopy(digits, 0, arrNew, 1, digits.length);
                return arrNew;
            }
            digits[k - 1] += 1;
            k--;
        }
        return digits;
    }

}
