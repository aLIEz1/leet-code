package com.github.aliez;

import java.util.ArrayList;
import java.util.List;

/**
 * 113 路径总和II
 *
 * @author lm
 * @date 2021/4/9 11:01
 */
public class Solution113 {

    private void getPath(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (root != null) {
            int newSum = sum;
            path.add(root.val);
            if (root.left == null && root.right == null) {
                if (newSum + root.val == target) {
                    paths.add(path);
                }
            } else {
                newSum += root.val;
                getPath(root.left, target, newSum, new ArrayList<>(path), paths);
                getPath(root.right, target, newSum, new ArrayList<>(path), paths);
            }
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        getPath(root, targetSum, 0, path, paths);
        return paths;
    }
}
