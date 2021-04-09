package com.github.aliez;

/**
 * 106 从中序与后序遍历序列构造二叉树
 *
 * @author lm
 * @date 2021/4/9 11:33
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        if (postorder.length == 1) {
            return root;
        }
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) {
                break;
            }
        }

        int[] inLeft = new int[delimiterIndex];
        int[] inRight = new int[inorder.length - delimiterIndex - 1];
        System.arraycopy(inorder, 0, inLeft, 0, delimiterIndex);
        System.arraycopy(inorder, delimiterIndex + 1, inRight, 0, inorder.length - delimiterIndex - 1);

        int[] postLeft = new int[delimiterIndex];
        int[] postRight = new int[postorder.length - delimiterIndex - 1];
        System.arraycopy(postorder, 0, postLeft, 0, delimiterIndex);
        System.arraycopy(postorder, delimiterIndex, postRight, 0, postorder.length - delimiterIndex - 1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;

    }
}
