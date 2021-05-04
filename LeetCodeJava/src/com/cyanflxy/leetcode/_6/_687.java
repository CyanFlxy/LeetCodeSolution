package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.05.04
 */
public class _687 {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            checkRootPath(root);
        }
        return max;
    }

    private int checkRootPath(TreeNode root) {
        int left = checkPath(root.left, root.val, 0);
        int right = checkPath(root.right, root.val, 0);

        int len = left + right;
        max = Math.max(max, len);
        return len;
    }

    private int checkPath(TreeNode root, int val, int len) {
        if (root == null) {
            max = Math.max(max, len);
            return len;
        }

        if (root.val == val) {
            len++;
            int left = checkPath(root.left, val, len);
            int right = checkPath(root.right, val, len);
            max = Math.max(max, left + right - len * 2);
            return Math.max(left, right);
        } else {
            checkRootPath(root);
            return len;
        }
    }
}
