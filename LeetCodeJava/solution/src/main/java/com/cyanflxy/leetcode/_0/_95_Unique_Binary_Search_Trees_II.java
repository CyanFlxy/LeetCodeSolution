package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <pre>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 * </pre>
 * Created by cyanflxy on 2018/5/22.
 */

public class _95_Unique_Binary_Search_Trees_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _95_Unique_Binary_Search_Trees_II object = new _95_Unique_Binary_Search_Trees_II();
        System.out.println(object.generateTrees(2));
    }

    public List<TreeNode> generateTrees(int n) {
        return treesOf(1, n);
    }

    private List<TreeNode> treesOf(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            return result;
        }

        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = treesOf(start, i - 1);
            List<TreeNode> right = treesOf(i + 1, end);

            if (left.isEmpty()) {
                for (TreeNode rn : right) {
                    TreeNode node = new TreeNode(i);
                    node.right = rn;
                    result.add(node);
                }
            } else if (right.isEmpty()) {
                for (TreeNode ln : left) {
                    TreeNode node = new TreeNode(i);
                    node.left = ln;
                    result.add(node);
                }
            } else {
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = ln;
                        node.right = rn;
                        result.add(node);
                    }
                }
            }
        }

        return result;
    }
}
