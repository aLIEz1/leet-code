package com.github.aliez;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222 完全二叉树的节点个数
 *
 * @author lm
 * @date 2021/4/8 14:15
 */
public class Solution222 {
    /**
     * 利用层序遍历统计个数,慢
     *
     * @param root 根节点
     * @return 节点个数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                count++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return count;

    }
}
