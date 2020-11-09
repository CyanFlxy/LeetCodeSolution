package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _129 {

    public static void main(String... args) {
    }

    private int value = 0;

    public int sumNumbers(TreeNode root) {
        calculate(root, 0);
        return value;
    }

    private void calculate(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        int here = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            value += here;
            return;
        }

        if (root.left != null) {
            calculate(root.left, here);
        }

        if (root.right != null) {
            calculate(root.right, here);
        }
    }
}