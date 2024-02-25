package data_structures.arrays.sorting;

import java.util.Arrays;

/**
 * Школа пытается ежегодно фотографировать всех учеников. Учащимся предлагается встать в одну шеренгу в порядке неубывания роста.
 * Пусть этот порядок будет представлен целочисленным массивом, expected где expected[i]— ожидаемый рост ученика в очереди.ith
 *
 * Вам дан целочисленный массив heights, представляющий текущий порядок ,
 * в котором стоят ученики. Каждый из них heights[i]представляет собой высоту ученика в строке ( с индексом 0 ).ith
 *
 * Возвращает количество индексов, гдеheights[i] != expected[i] .
 *
 * Example 1:
 *      Input: heights = [1,1,4,2,1,3]
 *      Output: 3
 *      Explanation:
 *      heights:  [1,1,4,2,1,3]
 *      expected: [1,1,1,2,3,4]
 *      Indices 2, 4, and 5 do not match.
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        System.out.println(heightChecker(arr));
    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] newArr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newArr);
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != newArr[i]) {
                count++;
            }
        }
        return count;
    }

}
