package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

public class _653 {

    private TreeNode root;
    private TreeNode current;
    private int k;

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        this.k = k;
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return false;
        }

        current = node;
        if (find(root, k - node.val)) {
            return true;
        }

        return dfs(node.left) || dfs(node.right);
    }

    private boolean find(TreeNode root, int x) {
        if (root == null) {
            return false;
        }
        if (root != current && root.val == x) {
            return true;
        }

        if (x < root.val) {
            return find(root.left, x);
        } else {
            return find(root.right, x);
        }

    }
}
