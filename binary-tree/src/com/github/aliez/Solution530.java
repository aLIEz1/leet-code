package com.github.aliez;

/**
 * 530 二叉搜索树的最小绝对差
 *
 * @author lm
 * @date 2021/4/9 16:42
 */
public class Solution530 {
    TreeNode pre;
    int minAbs=Integer.MAX_VALUE;

    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        if (pre != null) {
            minAbs = Math.min(root.val - pre.val, minAbs);
        }
        pre = root;
        travel(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        travel(root);
        return minAbs;
    }
}
