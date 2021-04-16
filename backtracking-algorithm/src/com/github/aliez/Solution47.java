package com.github.aliez;

import java.util.*;

/**
 * 47 全排列II
 *
 * @author lm
 * @date 2021/4/15 17:03
 */
public class Solution47 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> hashset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || hashset.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            hashset.add(nums[i]);
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        new Solution47().permuteUnique(nums);
    }
}
