package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <pre>
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 * </pre>
 * Created by cyanflxy on 2018/7/3.
 */

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _108_Convert_Sorted_Array_to_Binary_Search_Tree object = new _108_Convert_Sorted_Array_to_Binary_Search_Tree();
        System.out.println(object.sortedArrayToBST(new int[]{}));
        System.out.println(object.sortedArrayToBST(new int[]{-10,}));
        System.out.println(object.sortedArrayToBST(new int[]{-10, -3,}));
        System.out.println(object.sortedArrayToBST(new int[]{-10, -3, 0,}));
        System.out.println(object.sortedArrayToBST(new int[]{-10, -3, 0, 5,}));
        System.out.println(object.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTreeNode(nums, 0, nums.length);
    }

    public TreeNode createTreeNode(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        TreeNode head = new TreeNode(nums[middle]);

        if (middle > start) {
            head.left = createTreeNode(nums, start, middle);
        }

        if (middle + 1 < end) {
            head.right = createTreeNode(nums, middle + 1, end);
        }

        return head;
    }
}
