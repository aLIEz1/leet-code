package com.github.aliez;

/**
 * 二叉树Node节点
 *
 * @author lm
 * @date 2021/4/4 14:41
 */
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
