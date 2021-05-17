package com.cyanflxy.leetcode._9;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _993 {

    private TreeNode nodeX;
    private TreeNode nodeY;
    private TreeNode parentX;
    private TreeNode parentY;
    private int depthX = -1;
    private int depthY = -1;


    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }
        if (nodeX != null && nodeY != null) {
            return;
        }

        if (root.val == x) {
            nodeX = root;
            parentX = parent;
            depthX = depth;
        }

        if (root.val == y) {
            nodeY = root;
            parentY = parent;
            depthY = depth;
        }

        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);
    }
}
