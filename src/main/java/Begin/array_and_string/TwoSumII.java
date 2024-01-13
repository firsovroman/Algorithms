package Begin.array_and_string;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;


        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;

        while (first < last) {
            if (numbers[first] + numbers[last] == target) {
                int[] num = {first + 1, last + 1};
                return num;
            }

            if (numbers[first] + numbers[last] < target) {
                first++;
            }

            if (numbers[first] + numbers[last] > target) {
                last--;
            }

        }
        throw new IllegalArgumentException("Not found");
    }

}
