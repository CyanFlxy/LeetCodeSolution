package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.05.22
 */
public class _814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            }
        }

        return root;
    }
}
