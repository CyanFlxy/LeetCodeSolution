package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

public class _530 {
    private int result = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        if (pre != null) {
            result = Math.min(result, Math.abs(pre.val - node.val));
        }

        pre = node;
        inOrderTraversal(node.right);
    }
}
