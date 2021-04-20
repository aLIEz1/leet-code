package com.github.aliez;

/**
 * 45 跳跃游戏II
 *
 * @author lm
 * @date 2021/4/20 17:29
 */
public class Solution45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i <= nums.length; i++) {
            //下一步能覆盖的最大范围
            nextDistance = Math.max(nums[i] + i, nextDistance);
            //走到当前最大覆盖范围了
            if (i == curDistance) {
                //还没有到最后一个元素
                if (curDistance != nums.length - 1) {
                    step++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution45().jump(nums));
    }
}
