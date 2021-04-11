package com.github.aliez;

/**
 * 538 将二叉搜索树转换成累加树
 *
 * @author lm
 * @date 2021/4/11 9:10
 */
public class Solution538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = convertBST(root.right);
        int temp = root.val;
        root.val += sum;
        sum += temp;
        TreeNode left = convertBST(root.left);
        return root;
    }
}
