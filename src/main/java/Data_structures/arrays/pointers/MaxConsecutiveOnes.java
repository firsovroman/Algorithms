package Data_structures.arrays.pointers;


/**
 * Учитывая числа двоичного массива, верните максимальное количество последовательных единиц в массиве.
 * Example 1:
 *      Input: nums = [1,1,0,1,1,1]
 *      Output: 3
 *Example 2:
 *      Input: nums = [1,0,1,1,0,1]
 *      Output: 2
 *
 */
class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};

        int result = findMaxConsecutiveOnes(nums);
        int result2 = findMaxConsecutiveOnes(nums2);
        System.out.println(result);
        System.out.println(result2);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0;
        int longTimeCount = 0;

        for (int it : nums){
            if(it == 1) {
                currentCount++;
                longTimeCount = getLongTimeCount(currentCount, longTimeCount);
                continue;
            }
            currentCount = 0;
        }

        return longTimeCount;
    }

    private static int getLongTimeCount(int currentCount, int longTimeCount) {
        if(currentCount > longTimeCount) {
            longTimeCount = currentCount;
        }
        return longTimeCount;
    }
}
