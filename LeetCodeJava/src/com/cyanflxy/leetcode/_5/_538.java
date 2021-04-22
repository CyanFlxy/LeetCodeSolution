package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

public class _538 {
    private int currentValue;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.right);
        currentValue += node.val;
        node.val = currentValue;
        dfs(node.left);
    }
}
