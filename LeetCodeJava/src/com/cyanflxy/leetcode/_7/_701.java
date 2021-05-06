package com.cyanflxy.leetcode._7;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;
    }

}
