package Begin.array_and_string;

/**
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;

        System.out.println(minSubArrayLen(target, nums)); // 2

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int right = 0;
        int left = 0;
        int sum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                minSubArrayLength = Math.min(minSubArrayLength, (right - left) + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }

}
