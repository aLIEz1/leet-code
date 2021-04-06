package com.github.aliez;

import java.util.*;

/**
 * 590 N叉树的后序遍历
 *
 * @author lm
 * @date 2021/4/6 17:32
 */
public class Solution590 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans =new LinkedList<>();
        if (root==null){
            return ans;
        }
        Deque<Node> stack =new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            ans.addFirst(cur.val);
            List<Node> children = cur.children;
            for (Node child : children) {
                stack.push(child);
            }
        }
        return ans;
    }
}
