package com.github.aliez;

/**
 * 376 摆动序列
 *
 * @author lm
 * @date 2021/4/19 8:39
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前一对的差值
        int curDiff = 0;
        //前一对的差值
        int preDiff = 0;
        //峰值个数
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new Solution376().wiggleMaxLength(nums));
    }
}
