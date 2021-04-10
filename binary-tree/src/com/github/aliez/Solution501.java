package com.github.aliez;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 501 二叉搜索树中的众数
 *
 * @author lm
 * @date 2021/4/9 21:46
 */
public class Solution501 {
    public int[] findMode(TreeNode root) {
        int maxCount = 0;
        int count = 0;
        TreeNode pre = null;
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans.stream().mapToInt(i -> i).toArray();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null) {
                count = 1;
            } else if (pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
            if (count == maxCount) {
                ans.add(root.val);
            }
            if (count > maxCount) {
                maxCount = count;
                ans.clear();
                ans.add(root.val);
            }
            pre = root;
            root = root.right;
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
