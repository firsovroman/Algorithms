package Sorting_Algorithm;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = new int[]{34, 42, 35, 64, 15, 23, 12, 23, 88, 76};
        System.out.println("Before changing: " + Arrays.toString(array));


        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                    System.out.println(Arrays.toString(array));
                }
            }
        }

    }
}
