package com.github.aliez;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 700 二叉搜索树中的搜索
 *
 * @author lm
 * @date 2021/4/9 14:42
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val == val) {
                return cur;
            }
            if (cur.val > val && cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.val < val && cur.right != null) {
                stack.push(cur.right);
            }
        }
        return null;
    }

    public TreeNode searchBST3(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }


}
