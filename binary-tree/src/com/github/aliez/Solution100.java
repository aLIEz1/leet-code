package com.github.aliez;

import java.util.LinkedList;

/**
 * 100 相同的树
 *
 * @author lm
 * @date 2021/4/8 17:31
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if (t1 == null && t2 == null) {
                continue;
            }
            if ((t1 == null || t2 == null || (t1.val != t2.val))) {
                return false;
            } else {
                stack.push(t1.left);
                stack.push(t2.left);
                stack.push(t1.right);
                stack.push(t2.right);
            }
        }
        return true;
    }
}
