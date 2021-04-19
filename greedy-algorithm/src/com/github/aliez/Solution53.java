package com.github.aliez;

/**
 * 53 最大子序和
 *
 * @author lm
 * @date 2021/4/19 9:21
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            if (count > ans) {
                ans = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return ans;
    }
}
