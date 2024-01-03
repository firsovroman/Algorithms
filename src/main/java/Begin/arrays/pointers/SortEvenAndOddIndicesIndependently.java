package Begin.arrays.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEvenAndOddIndicesIndependently {

    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 3};
        System.out.println(Arrays.toString(sortEvenOdd(arr))); // 2,3,4,1
    }


    public static int[] sortEvenOdd(int[] nums) {
        List<Integer> oddIndices = new ArrayList<>();
        List<Integer> evenIndices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenIndices.add(nums[i]);
            } else {
                oddIndices.add(nums[i]);
            }
        }

        Collections.sort(oddIndices, Collections.reverseOrder());
        Collections.sort(evenIndices);

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evenIndices.get(j++);
            } else {
                nums[i] = oddIndices.get(k++);
            }
        }

        return nums;
    }

}
