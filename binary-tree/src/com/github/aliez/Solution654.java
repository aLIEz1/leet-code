package com.github.aliez;

/**
 * 654最大二叉树
 *
 * @author lm
 * @date 2021/4/9 12:56
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = 0;
        int delimiterIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                delimiterIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);

        if (nums.length==1){
            return root;
        }

        int[] left = new int[delimiterIndex];
        int[] right = new int[nums.length-delimiterIndex-1];
        System.arraycopy(nums,0,left,0,delimiterIndex);
        System.arraycopy(nums,delimiterIndex+1,right,0,nums.length-delimiterIndex-1);
        root.left=constructMaximumBinaryTree(left);
        root.right=constructMaximumBinaryTree(right);
        return root;
    }
}
