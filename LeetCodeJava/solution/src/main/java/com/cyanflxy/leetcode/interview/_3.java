package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
 *
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _3 {

    public static void main(String... args) {
        TreeNode node = TreeNode.create(1, null, 2, null, 3, null, 4, null, 5);
        new _3().pathSum(node, 3);
    }

    private int count;
    private Set<TreeNode> rootNood;

    public int pathSum(TreeNode root, int sum) {
        count = 0;
        rootNood = new HashSet<>();
        if (root != null) {
            rootNood.add(root);
            checkNode(root, sum, sum);
        }
        return count;
    }

    private void checkNode(TreeNode node, int sum, int total) {
        if (node.val == sum) {
            count += 1;
        }
        int remain = sum - node.val;

        if (node.left != null) {
            checkNode(node.left, remain, total);
            if (!rootNood.contains(node.left)) {
                rootNood.add(node.left);
                checkNode(node.left, total, total);
            }
        }

        if (node.right != null) {
            checkNode(node.right, remain, total);
            if (!rootNood.contains(node.right)) {
                rootNood.add(node.right);
                checkNode(node.right, total, total);
            }
        }

    }
}
