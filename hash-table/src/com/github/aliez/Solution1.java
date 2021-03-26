package com.github.aliez;

import java.util.HashMap;

/**
 * 1
 *
 * @author lm
 * @date 2021/3/26 14:33
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i],i);
        }

        return new int[]{};

    }
}
