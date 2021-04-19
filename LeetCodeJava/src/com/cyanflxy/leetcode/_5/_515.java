package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _515 {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) {
            return;
        }

        if (result.size() <= deep) {
            result.add(node.val);
        } else {
            if (result.get(deep) < node.val) {
                result.set(deep, node.val);
            }
        }

        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }
}
