package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * </pre>
 * return its zigzag level order traversal as:
 * <pre>
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/6/30.
 */

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _103_Binary_Tree_Zigzag_Level_Order_Traversal object = new _103_Binary_Tree_Zigzag_Level_Order_Traversal();
        System.out.println(object.zigzagLevelOrder(TreeNode.create(3, 9, 20, null, null, 15, 7)));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        readNodeVal(result, root, 0);
        return result;
    }

    private void readNodeVal(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(node.val);
        } else {
            result.get(level).add(0, node.val);
        }

        readNodeVal(result, node.left, level + 1);
        readNodeVal(result, node.right, level + 1);
    }

}
