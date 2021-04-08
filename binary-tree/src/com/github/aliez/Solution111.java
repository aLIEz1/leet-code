package com.github.aliez;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111 二叉树的最小深度
 *
 * @author lm
 * @date 2021/4/8 10:13
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            int flag = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                assert cur != null;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //当首次遍历到左右节点都为空的节点的时候说明此节点为最小高度，此时退出循环，flag的作用是告诉外层循环退出
                if (cur.left == null && cur.right == null) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        return depth;
    }
}
