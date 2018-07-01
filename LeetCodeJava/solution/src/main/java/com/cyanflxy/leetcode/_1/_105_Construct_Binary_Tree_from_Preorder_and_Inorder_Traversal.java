package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * Created by cyanflxy on 2018/7/1.
 */

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal object = new _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        System.out.println(object.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    // 可以不使用循环解决此问题 - 提供当前的Head值，并在inorder中寻找该值
    private TreeNode buildTree(int[] preorder, int preIndex, int[] inorder, int inFrom, int inTo) {
        int value = preorder[preIndex];
        TreeNode head = new TreeNode(value);

        for (int i = inFrom; i < inTo; i++) {
            if (inorder[i] == value) {

                if (i != inFrom) {
                    head.left = buildTree(preorder, preIndex + 1, inorder, inFrom, i);
                }

                if (i != inTo - 1) {
                    head.right = buildTree(preorder, preIndex + i - inFrom + 1, inorder, i + 1, inTo);
                }

                break;
            }
        }

        return head;
    }

}
