package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.TreeNode;
import javafx.util.Pair;

/**
 * @author cyanflxy
 * @since 2021.06.04
 */
public class _235 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        p.right = q;
        new _235().lowestCommonAncestor(p, p, q);
    }

    private TreeNode parent;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return parent;
    }

    private Pair<Boolean, Boolean> dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || parent != null) {
            return new Pair<>(false, false);
        }
        boolean first = false;
        boolean second = false;

        if (root == p) {
            first = true;
        }
        if (root == q) {
            second = true;
        }

        Pair<Boolean, Boolean> left = dfs(root.left, p, q);
        first |= left.getKey();
        second |= left.getValue();

        if (parent == null) {
            if (first && second) {
                parent = root;
                return new Pair<>(true, true);
            }
        }

        Pair<Boolean, Boolean> right = dfs(root.right, p, q);
        first |= right.getKey();
        second |= right.getValue();

        if (parent == null) {
            if (first && second) {
                parent = root;
                return new Pair<>(true, true);
            }
        }

        return new Pair<>(first, second);
    }
}
