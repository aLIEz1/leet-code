package com.github.aliez;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559 N叉树的最大深度
 *
 * @author lm
 * @date 2021/4/7 19:09
 */
public class Solution559 {
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        int max=0;
        List<Node> children = root.children;
        for (Node child : children) {
            max=Math.max(max, maxDepth(child));
        }
        return max+1;
    }

    public int maxDepth2(Node root) {
        if (root==null){
            return 0;
        }
        Queue<Node> queue =new LinkedList<>();
        queue.offer(root);
        int count=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                List<Node> children = cur.children;
                for (Node child : children) {
                    if (child!=null){
                        queue.offer(child);
                    }
                }
            }
            count++;

        }
        return count;
    }
}
