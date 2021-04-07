package com.github.aliez;

import java.util.LinkedList;

/**
 * 101 对称二叉树
 *
 * @author lm
 * @date 2021/4/7 14:35
 */
public class Solution101 {
    private boolean isSam(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        boolean out = isSam(left.left, right.right);
        boolean inner = isSam(left.right, right.left);
        return out && inner;

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSam(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //LinkedList 允许push(null)
        //Queue不允许添加null
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null || (left.val != right.val))) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);

        }
        return true;
    }
}
