package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

public class _563 {
    private int sum;

    public int findTilt(TreeNode root) {
        calTilt(root);
        return sum;
    }

    private int calTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = calTilt(root.left);
        int right = calTilt(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
// 和可以在计算过程中累加
//    private int sum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return root.val + sum(root.left) + sum(root.right);
//    }
}
