package com.github.aliez;

import java.util.ArrayList;
import java.util.List;

/**
 * 257 二叉树的所有路径
 *
 * @author lm
 * @date 2021/4/8 15:22
 */
public class Solution257 {

    private void getPath(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            //如果当前节点为叶子节点
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                //如果当前节点不是叶子节点，继续递归
                sb.append("->");
                getPath(root.left, sb.toString(), paths);
                getPath(root.right, sb.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getPath(root, "", paths);
        return paths;
    }
}
