package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/description/
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * <pre>
 * Input:
 *   1         1
 *  / \       / \
 * 2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 *
 * Output: true
 * </pre>
 * Example 2:
 * <pre>
 * Input:
 *   1         1
 *  /           \
 * 2             2
 *
 * [1,2],     [1,null,2]
 *
 * Output: false
 * </pre>
 * Example 3:
 * <pre>
 * Input:
 *   1         1
 *  / \       / \
 * 2   1     1   2
 *
 * [1,2,1],   [1,1,2]
 *
 * Output: false
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/5/26.
 */

public class _100_Same_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _100_Same_Tree object = new _100_Same_Tree();
        System.out.println(object.isSameTree(new TreeNode(0), null));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
