package com.cyanflxy.leetcode._10;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.06.24
 */
public class _1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int parent) {
        if (root == null) {
            return parent;
        }

        if (root.left == null && root.right == null) {
            return parent * 2 + root.val;
        }

        int result = 0;
        if (root.left != null) {
            result += dfs(root.left, parent * 2 + root.val);
        }
        if (root.right != null) {
            result += dfs(root.right, parent * 2 + root.val);
        }
        return result;
    }
}
