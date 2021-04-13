package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90 子集II
 *
 * @author lm
 * @date 2021/4/13 17:24
 */
public class Solution90 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int pre=Integer.MAX_VALUE;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (pre == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
            pre = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution90().subsetsWithDup(nums));
    }

}
