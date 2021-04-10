package com.github.aliez;

/**
 * 450 删除二叉搜索树中的节点
 *
 * @author lm
 * @date 2021/4/10 18:54
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            }
            if (cur.val < key) {
                cur = cur.right;
            }
        }
        //找不到节点值等于key的情况
        if (cur==null){
            return root;
        }
        //只有头节点的情况
        if (pre == null) {
            return deleteOneNode(cur);
        }
        if (pre.left != null && pre.left.val == key) {
            pre.left = deleteOneNode(cur);
        }
        if (pre.right != null && pre.right.val == key) {
            pre.right = deleteOneNode(cur);
        }
        return root;
    }

    private TreeNode deleteOneNode(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        if (cur.right == null) {
            return cur.left;
        }
        TreeNode temp = cur.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = cur.left;
        return cur.right;

    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                //将当前节点删除
                root = root.right;
                return root;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
