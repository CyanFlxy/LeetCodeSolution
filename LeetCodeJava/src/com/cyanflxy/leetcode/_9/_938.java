package com.cyanflxy.leetcode._9;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.06.09
 */
public class _938 {
    private int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        int v = root.val;
        if (v >= low && v <= high) {
            sum += v;
        }

        if (v >= low) {
            dfs(root.left, low, high);
        }

        if (v <= high) {
            dfs(root.right, low, high);
        }
    }
}
