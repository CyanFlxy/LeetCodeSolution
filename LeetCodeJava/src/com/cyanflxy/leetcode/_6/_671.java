package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

public class _671 {
    public int findSecondMinimumValue(TreeNode root) {
        return getSmallDiff(root, root.val);
    }

    private int getSmallDiff(TreeNode root, int src) {
        if (root == null) {
            return -1;
        }
        if (root.val != src) {
            return root.val;
        }

        int left = getSmallDiff(root.left, src);
        int right = getSmallDiff(root.right, src);
        if (left > 0 && right > 0) {
            return Math.min(left, right);
        } else if (left > 0) {
            return left;
        } else {
            return right;
        }
    }
}
