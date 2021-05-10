package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2021.05.10
 */
public class _872 {
    class Solution {

        private boolean record = true;
        private int leafCount = 0;
        private int[] leaf = new int[110];

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            dfs(root1);
            int count = leafCount;
            leafCount = 0;
            record = false;
            return dfs(root2) && count == leafCount;
        }

        private boolean dfs(TreeNode node) {
            if (node == null) {
                return true;
            }

            if (node.left == null && node.right == null) {
                if (record) {
                    leaf[leafCount++] = node.val;
                    return true;
                } else {
                    return leaf[leafCount++] == node.val;
                }
            }
            return dfs(node.left) && dfs(node.right);
        }
    }
}
