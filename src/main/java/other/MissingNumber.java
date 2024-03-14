package other;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0,1};

        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2; // Сумма натуральных чисел от 0 до n
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}
