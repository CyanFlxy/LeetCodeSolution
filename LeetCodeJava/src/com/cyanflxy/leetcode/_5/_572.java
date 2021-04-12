package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

public class _572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }

        return traversal(s, t);
    }

    private boolean traversal(TreeNode node, TreeNode t) {
        if (node == null) {
            return false;
        }
        if (isSameTree(node, t)) {
            return true;
        }
        return traversal(node.left, t) || traversal(node.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }

        return false;
    }
}
