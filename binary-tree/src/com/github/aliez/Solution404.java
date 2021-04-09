package com.github.aliez;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 404 左子叶之和
 *
 * @author lm
 * @date 2021/4/9 9:45
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int middleValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            middleValue = root.left.val;
        }
        return middleValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.left != null && cur.left.left == null && cur.left.right == null) {
                result += cur.left.val;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }
}
