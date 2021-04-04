package com.github.aliez;

import java.util.*;

/**
 * 145 二叉树后序遍历
 *
 * @author lm
 * @date 2021/4/4 14:50
 */
public class Solution145 {
    ArrayList<Integer> ans = new ArrayList<>();

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return ans;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;

    }
}
