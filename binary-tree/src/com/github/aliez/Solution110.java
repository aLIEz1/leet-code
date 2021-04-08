package com.github.aliez;

/**
 * 110 平衡二叉树
 *
 * @author lm
 * @date 2021/4/8 14:39
 */
public class Solution110 {
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        int result;
        if (Math.abs(left - right) > 1) {
            result = -1;
        } else {
            result = Math.max(left, right) + 1;
        }
        return result;
    }

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;

    }
}
