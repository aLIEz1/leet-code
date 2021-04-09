package com.github.aliez;

import java.util.HashSet;
import java.util.Set;

/**
 * 112 路径总和
 *
 * @author lm
 * @date 2021/4/9 10:35
 */
public class Solution112 {

    private void getSum(TreeNode root, int sum, Set<Integer> sums) {
        if (root != null) {
            int newSum = sum;
            if (root.left == null && root.right == null) {
                newSum+=root.val;
                sums.add(newSum);
            } else {
                newSum += root.val;
                getSum(root.left, newSum, sums);
                getSum(root.right, newSum, sums);
            }
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        //当targetSum==root.val的时候,说明targetSum-root==0,此时路径存在，直接返回true;
        if (root.left==null&&root.right==null&&targetSum==root.val){
            return true;
        }
        return hasPathSum(root.left,targetSum- root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
