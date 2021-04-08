package com.github.aliez;

/**
 * 572 另一个树的子树
 *
 * @author lm
 * @date 2021/4/8 17:54
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        //s和t有一个不为空
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val && isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
