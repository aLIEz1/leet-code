package com.github.aliez;

import java.util.ArrayList;
import java.util.List;

/**
 * 879 递增顺序搜索树
 *
 * @author lm
 * @date 2021/4/25 16:21
 */
public class Solution879 {

    List<Integer> list = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode cur = node;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return node;
    }
}
