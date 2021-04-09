package com.github.aliez;

/**
 * 98 验证二叉搜索树
 *
 * @author lm
 * @date 2021/4/9 15:08
 */
public class Solution98 {

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        //记录前一个节点
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
