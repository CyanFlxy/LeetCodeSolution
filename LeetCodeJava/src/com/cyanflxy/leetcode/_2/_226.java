package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2020/10/28
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
