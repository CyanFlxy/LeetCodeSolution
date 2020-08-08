package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _144 {

    public static void main(String... args) {
        TreeNode node = TreeNode.create(1, 4, 3, 2);
        new _144().preorderTraversal(node);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        List<TreeNode> waiting = new LinkedList<>();
        waiting.add(root);

        while (!waiting.isEmpty()) {
            TreeNode node = waiting.remove(0);
            list.add(node.val);
            if (node.right != null) {
                waiting.add(0, node.right);
            }
            if (node.left != null) {
                waiting.add(0, node.left);
            }
        }

        return list;
    }
}
