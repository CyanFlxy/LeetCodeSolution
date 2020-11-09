package com.cyanflxy.leetcode._3;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2020/8/5
 */
public class _337 {

    public int rob(TreeNode root) {
        int robWidthRoot = maxRob(root, true);
        int robWidthOutRoot = maxRob(root, false);

        return Math.max(robWidthOutRoot, robWidthRoot);
    }

    // 效率低下
    private int maxRob(TreeNode root, boolean robRoot) {
        if (root == null) {
            return 0;
        }

        if (robRoot) {
            return root.val + maxRob(root.left, false) + maxRob(root.right, false);
        } else {
            return Math.max(maxRob(root.left, true), maxRob(root.left, false)) +
                    Math.max(maxRob(root.right, true), maxRob(root.right, false));
        }
    }

}
