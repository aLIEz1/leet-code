package com.github.aliez;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104 二叉树的最大深度
 *
 * @author lm
 * @date 2021/4/7 18:58
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int count=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }

            }
            count++;
        }
        return count;
    }
}
