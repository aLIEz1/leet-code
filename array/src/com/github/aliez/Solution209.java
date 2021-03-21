package com.github.aliez;

/**
 * 209
 *
 * @author lm
 * @date 2021/3/19 14:36
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int subLength = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = (j - i + 1);
                result = Math.min(subLength, result);
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
