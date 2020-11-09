package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _124 {

    public static void main(String... args) {
//        new _124().maxPathSum(TreeNode.create(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6));
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxFromRoot(root);
        return maxSum;
    }

    // 这个是更快的算法
    private int maxFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxFromLeft = Math.max(0, maxFromRoot(root.left));
        int maxFromRight = Math.max(0, maxFromRoot(root.right));
        int maxWithRoot = root.val + maxFromLeft + maxFromRight;
        maxSum = Math.max(maxSum, maxWithRoot);

        return root.val + Math.max(maxFromLeft, maxFromRight);
    }

//    public int maxPathSum2(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return Math.max(maxWithRoot(root), maxWithoutRoot(root));
//    }
//
//    private int maxWithRoot(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = Math.max(0, maxFromRoot(root.left));
//        int rightMax = Math.max(0, maxFromRoot(root.right));
//        return root.val + leftMax + rightMax;
//    }
//
//    private int maxWithoutRoot(TreeNode root) {
//        int left, right;
//        if (root.left != null) {
//            left = maxPathSum(root.left);
//        } else {
//            left = Integer.MIN_VALUE;
//        }
//
//        if (root.right != null) {
//            right = maxPathSum(root.right);
//        } else {
//            right = Integer.MIN_VALUE;
//        }
//        return Math.max(left, right);
//    }
//
//    private int maxFromRoot(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int maxFromLeft = Math.max(0, maxFromRoot(root.left));
//        int maxFromRight = Math.max(0, maxFromRoot(root.right));
//        return root.val + Math.max(maxFromLeft, maxFromRight);
//    }
}