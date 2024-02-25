package data_structures.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Название задачи: 4Sum II
 */
public class FourSumII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4)); // 2
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCountAB = new HashMap<>();

        // Подсчитываем все возможные суммы из nums1 и nums2
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sumAB = num1 + num2;
                sumCountAB.put(sumAB, sumCountAB.getOrDefault(sumAB, 0) + 1);
            }
        }

        int count = 0;

        // Проверяем суммы в nums3 и nums4
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = -(num3 + num4);
                count += sumCountAB.getOrDefault(target, 0);
            }
        }

        return count;
    }

}
