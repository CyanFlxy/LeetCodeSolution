package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.TreeNode;
import javafx.util.Pair;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _897 {
    public TreeNode increasingBST(TreeNode root) {
        Pair<TreeNode, TreeNode> tree = helper(root);
        return tree != null ? tree.getKey() : null;
    }

    private Pair<TreeNode, TreeNode> helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        Pair<TreeNode, TreeNode> left = helper(root.left);
        Pair<TreeNode, TreeNode> right = helper(root.right);
        root.left = null;
        root.right = null;

        TreeNode head;
        TreeNode tail;

        if (left != null) {
            head = left.getKey();
            left.getValue().right = root;

            if (right != null) {
                root.right = right.getKey();
                tail = right.getValue();
            } else {
                tail = root;
            }
        } else {
            head = root;
            if (right != null) {
                head.right = right.getKey();
                tail = right.getValue();
            } else {
                tail = root;
            }
        }

        return new Pair<>(head, tail);
    }
}
