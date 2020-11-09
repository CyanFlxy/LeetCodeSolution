package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <pre>
 * Input: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *
 * Output: [1,3,2]
 * </pre>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * Created by cyanflxy on 2018/5/22.
 */

public class _94_Binary_Tree_Inorder_Traversal {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _94_Binary_Tree_Inorder_Traversal object = new _94_Binary_Tree_Inorder_Traversal();
        System.out.println(object.inorderTraversal(new TreeNode(2)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalTree(result, root);
        return result;
    }

    private void traversalTree(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        traversalTree(result, root.left);
        result.add(root.val);
        traversalTree(result, root.right);
    }
}
