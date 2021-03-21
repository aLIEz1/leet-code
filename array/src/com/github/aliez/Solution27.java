package com.github.aliez;

/**
 * 解决方案
 *
 * @author lm
 * @date 2021/3/15 15:00
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
