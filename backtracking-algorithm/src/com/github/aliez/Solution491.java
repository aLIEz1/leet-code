package com.github.aliez;

import java.util.*;

/**
 * 491 递增子序列
 *
 * @author lm
 * @date 2021/4/13 17:41
 */
public class Solution491 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        if (startIndex > 1) {
            ans.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length) {
            return;
        }

        Set<Integer> hashset =new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.peekLast())
                    || !hashset.contains(nums[i])) {
                hashset.add(nums[i]);
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }

        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1, 1};
        System.out.println(new Solution491().findSubsequences(nums));
    }
}
