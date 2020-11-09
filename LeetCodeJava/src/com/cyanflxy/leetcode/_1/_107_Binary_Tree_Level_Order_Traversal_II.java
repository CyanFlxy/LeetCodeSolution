package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * return its bottom-up level order traversal as:
 * <pre>
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/7/3.
 */

public class _107_Binary_Tree_Level_Order_Traversal_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _107_Binary_Tree_Level_Order_Traversal_II object = new _107_Binary_Tree_Level_Order_Traversal_II();
        System.out.println(object.levelOrderBottom(TreeNode.create(3, 9, 20, null, null, 15, 7)));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        readNodeVal(result, root, 0);
        return result;
    }

    private void readNodeVal(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        List<Integer> list;

        if (result.size() > level) {
            list = result.get(result.size() - level - 1);
        } else {
            list = new ArrayList<>();
            result.add(0, list);
        }

        list.add(node.val);

        readNodeVal(result, node.left, level + 1);
        readNodeVal(result, node.right, level + 1);
    }
}
