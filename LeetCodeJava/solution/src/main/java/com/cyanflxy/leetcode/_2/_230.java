package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2020/11/3
 */
public class _230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int leftCount = treeCount(root.left);

        if (k <= leftCount) {
            return kthSmallest(root.left, k);
        } else if (k == leftCount + 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }

    }

    private int treeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + treeCount(root.left) + treeCount(root.right);
    }
}
