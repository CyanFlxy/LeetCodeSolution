package com.cyanflxy.leetcode._12;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _1261 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
        boolean find = findElements.find(1);
        find = findElements.find(2);
    }

    static class FindElements {
        private TreeNode rootNode;

        public FindElements(TreeNode root) {
            rootNode = root;
            if (rootNode != null) {
                rootNode.val = 0;
                setLeaf(root);
            }
        }

        private void setLeaf(TreeNode root) {
            int val = root.val;
            if (root.left != null) {
                root.left.val = val * 2 + 1;
                setLeaf(root.left);
            }
            if (root.right != null) {
                root.right.val = val * 2 + 2;
                setLeaf(root.right);
            }
        }

        public boolean find(int target) {
            if (target < 0) {
                return false;
            }

            TreeNode node = rootNode;
            target++;
            int bit = Integer.highestOneBit(target) >> 1;

            while (bit > 0 && node != null) {
                if ((target & bit) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                bit >>= 1;
            }

            return node != null;
        }
    }
}