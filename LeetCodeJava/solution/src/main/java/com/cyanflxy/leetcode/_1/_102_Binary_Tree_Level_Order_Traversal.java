package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * <pre>
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/6/30.
 */

public class _102_Binary_Tree_Level_Order_Traversal {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _102_Binary_Tree_Level_Order_Traversal object = new _102_Binary_Tree_Level_Order_Traversal();
        System.out.println(object.levelOrder(TreeNode.create(3, 9, 20, null, null, 15, 7)));
    }

    // 递归法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        readNodeVal(result, root, 0);
        return result;
    }

    private void readNodeVal(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        List<Integer> values;
        if (result.size() <= level) {
            values = new ArrayList<>();
            result.add(values);
        } else {
            values = result.get(level);
        }
        values.add(node.val);

        readNodeVal(result, node.left, level + 1);
        readNodeVal(result, node.right, level + 1);
    }

    // 迭代法
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        List<TreeNode> nextLevel = new ArrayList<>();

        while (!nodeList.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (node != null) {
                    integers.add(node.val);
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            nodeList.clear();

            List<TreeNode> temp = nodeList;
            nodeList = nextLevel;
            nextLevel = temp;

            if (!integers.isEmpty()) {
                result.add(integers);
            }
        }

        return result;
    }
}
