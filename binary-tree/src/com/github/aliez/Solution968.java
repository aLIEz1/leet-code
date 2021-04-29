package com.github.aliez;

/**
 * 968 监控二叉树
 *
 * @author lm
 * @date 2021/4/27 17:06
 */
public class Solution968 {

    private boolean isValid(TreeNode root) {
        if (root.left != null) {
            return root.left.left != null || root.left.right != null;
        }
        if (root.right != null) {
            return root.right.left != null || root.right.right != null;
        }
        return false;
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isValid(root)) {
            return 1 + minCameraCover(root.left) + minCameraCover(root.right);
        } else {
            return 0;
        }
    }
}
