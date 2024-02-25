package data_structures.array_and_string;

import java.util.Arrays;

public class ArrayPartition {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 1; i < nums.length; i += 2) {
            sum += Math.min(nums[i - 1], nums[i]);
        }
        return sum;
    }

}
