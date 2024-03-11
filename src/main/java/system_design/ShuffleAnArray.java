package system_design;

import java.util.*;

public class ShuffleAnArray {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution solution = new Solution(arr);
        System.out.println("shuffle - " + Arrays.toString(solution.shuffle()));    // не [1,2,3]
        System.out.println("reset - " + Arrays.toString(solution.reset()));        // [1,2,3]
        System.out.println("shuffle - " + Arrays.toString(solution.shuffle()));    // не [1,2,3]
    }


}

class Solution {

    int[] source;


    public Solution(int[] nums) {
        source = nums;
    }

    public int[] reset() {
        return source;
    }

    public int[] shuffle() {
        int[] curr = Arrays.copyOf(source, source.length);

        Random random = new Random();
        for (int i = curr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = curr[index];
            curr[index] = curr[i];
            curr[i] = temp;
        }

        return curr;
    }
}