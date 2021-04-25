package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

public class _623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRow(root, true, val, depth);
    }

    public TreeNode addOneRow(TreeNode root, boolean isLeft, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            if (isLeft) {
                node.left = root;
            } else {
                node.right = root;
            }
            return node;
        }

        if (root != null) {
            root.left = addOneRow(root.left, true, val, depth - 1);
            root.right = addOneRow(root.right, false, val, depth - 1);
            return root;
        }
        return null;
    }
}
