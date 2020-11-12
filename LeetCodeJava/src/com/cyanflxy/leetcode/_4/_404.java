package com.cyanflxy.leetcode._4;

import com.cyanflxy.leetcode.help.TreeNode;

public class _404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            return left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

}
