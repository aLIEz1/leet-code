package com.github.aliez;

/**
 * 150 从中序与前序遍历序列构造二叉树
 *
 * @author lm
 * @date 2021/4/9 12:32
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        if (preorder.length == 1) {
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

        int[] preLeft = new int[delimiterIndex];
        int[] preRight = new int[preorder.length - delimiterIndex - 1];
        System.arraycopy(inorder, 0, inLeft, 0, delimiterIndex);
        System.arraycopy(inorder, delimiterIndex + 1, inRight, 0, inorder.length - delimiterIndex - 1);
        System.arraycopy(preorder, 1, preLeft, 0, delimiterIndex);
        System.arraycopy(preorder, delimiterIndex + 1, preRight, 0, preorder.length - delimiterIndex - 1);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;

    }
}
