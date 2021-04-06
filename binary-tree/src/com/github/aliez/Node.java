package com.github.aliez;

import java.util.List;

/**
 * N 叉树节点
 *
 * @author lm
 * @date 2021/4/6 17:19
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
