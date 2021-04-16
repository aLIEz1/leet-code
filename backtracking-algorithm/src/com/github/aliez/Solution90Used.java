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
public class Solution90Used {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Solution90Used().subsetsWithDup(nums));
    }

}
