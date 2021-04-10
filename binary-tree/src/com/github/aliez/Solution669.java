package com.github.aliez;

/**
 * 669 修剪二叉搜索树
 *
 * @author lm
 * @date 2021/4/10 21:35
 */
public class Solution669 {
    /**
     * 有返回值，更好操作
     * 当当前节点的数值比low小或者比high大的时候删除该节点
     * 比low小 删除该节点的左子树
     * 修剪右子树
     * 比high大 删除该节点的右子树
     * 修剪左子树
     *
     * @param root
     * @param low
     * @param high
     * @return
     */

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
