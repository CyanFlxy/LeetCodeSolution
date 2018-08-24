package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/description/
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * </pre>
 * Return:
 * <pre>
 * [
 *      [5,4,11,2],
 *      [5,8,4,5]
 * ]
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/8/24.
 */
public class _113_Path_Sum_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _113_Path_Sum_II object = new _113_Path_Sum_II();
        System.out.println(object.pathSum(
                TreeNode.create(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1),
                22));
    }

    /**
     * 采用 创建-合并 的方式，总体上创建List实例过多，不如先加再减的方式速度更快。
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> value = new ArrayList<>();
                value.add(sum);
                result.add(value);
            }
            return result;
        }

        if (root.left != null) {
            result.addAll(pathSum(root.left, sum - root.val));
        }

        if (root.right != null) {
            result.addAll(pathSum(root.right, sum - root.val));
        }

        for (List<Integer> list : result) {
            list.add(0, root.val);
        }

        return result;
    }

}
