package com.github.aliez;

/**
 * 235 二叉搜索树的最近公共祖先
 *
 * @author lm
 * @date 2021/4/9 17:33
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > q.val && root.val > p.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
