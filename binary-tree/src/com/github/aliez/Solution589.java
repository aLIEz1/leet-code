package com.github.aliez;

import java.util.*;

/**
 * 589 N叉树的前序遍历
 *
 * @author lm
 * @date 2021/4/6 17:18
 */
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            ans.add(cur.val);
            List<Node> children = cur.children;
            if (children != null) {
                Collections.reverse(children);
                for (Node child : children) {
                    stack.push(child);
                }
            }
        }
        return ans;
    }
}
