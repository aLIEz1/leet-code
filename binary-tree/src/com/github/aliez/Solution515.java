package com.github.aliez;

import java.util.*;

/**
 * 515在每个树行中寻找最大值
 *
 * @author lm
 * @date 2021/4/6 16:41
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
//            int[] nums = new int[size];
            //使用PriorityQueue效率更高
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                assert cur != null;
//                nums[i] = cur.val;
                priorityQueue.offer(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
//            int i = Arrays.stream(nums).max().getAsInt();
//            ans.add(i);
            ans.add(priorityQueue.poll());
        }
        return ans;
    }
}
