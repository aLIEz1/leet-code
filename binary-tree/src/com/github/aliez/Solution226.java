package com.github.aliez;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 226 翻转二叉树
 *
 * @author lm
 * @date 2021/4/6 17:38
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return root;
    }

    public TreeNode invertTreePre(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreePre(root.left);
        invertTreePre(root.right);
        return root;
    }

    /**
     * 此解法为错误示范，中序遍历中间交换后右子树变成了左子树，这样做会将左子树翻转两次
     * 正确解法应该是将invertTree(root.right); 改成 invertTree(root.left)
     * @param root
     * @return
     */
    public TreeNode invertTreeIn(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeIn(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeIn(root.right);
        return root;
    }
}
