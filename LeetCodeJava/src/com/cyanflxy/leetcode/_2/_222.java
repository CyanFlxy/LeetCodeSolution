package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2020/10/28
 */
public class _222 {
    int count;

    public int countNodes(TreeNode root) {
        if (root != null) {
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }

        return count;
    }
}
