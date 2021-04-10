package com.github.aliez;

/**
 * 701 二叉搜索树中的插入操作
 *
 * @author lm
 * @date 2021/4/10 12:41
 */
public class Solution701 {

    public void insert(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val > val) {
            if (root.left != null) {
                insert(root.left, val);
            } else {
                root.left = new TreeNode(val);
                return;
            }
        }
        if (root.val < val) {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new TreeNode(val);
                return;
            }
        }

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;

    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST2(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null) {
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
            }
            if (cur.val < val) {
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val < pre.val) {
            pre.left =node;
        }else {
            pre.right=node;
        }
        return root;
    }
}
