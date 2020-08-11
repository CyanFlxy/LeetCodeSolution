package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/11
 */
public class _199 {

    public static void main(String... args) {
        new _199().rightSideView(TreeNode.create(1, 2, 3, null, 5, null, 4));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travelTree(root, list, 0);
        return list;
    }

    private void travelTree(TreeNode node, List<Integer> list, int deep) {
        if (node == null) {
            return;
        }

        if (list.size() <= deep) {
            list.add(0);
        }

        list.set(deep, node.val);
        travelTree(node.left, list, deep + 1);
        travelTree(node.right, list, deep + 1);
    }
}
