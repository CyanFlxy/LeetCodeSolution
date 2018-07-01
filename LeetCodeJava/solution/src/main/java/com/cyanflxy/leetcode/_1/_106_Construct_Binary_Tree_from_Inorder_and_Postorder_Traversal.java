package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * <pre>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * </pre>
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

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal object = new _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        System.out.println(object.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        return buildTree(inorder, postorder, inorder.length, 0, postorder.length - 1);
    }

    // 可以不使用循环解决此问题 - 提供当前的Head值，并在inorder中寻找该值
    private TreeNode buildTree(int[] inorder, int[] postOrder, int inFrom, int inTo, int postIndex) {
        int value = postOrder[postIndex];
        TreeNode head = new TreeNode(value);

        for (int i = inFrom - 1; i >= inTo; i--) {
            if (inorder[i] == value) {

                if (i != inFrom - 1) {
                    head.right = buildTree(inorder, postOrder, inFrom, i + 1, postIndex - 1);
                }

                if (i != inTo) {
                    head.left = buildTree(inorder, postOrder, i, inTo, postIndex - (inFrom - i));
                }

                break;
            }
        }

        return head;
    }
}
