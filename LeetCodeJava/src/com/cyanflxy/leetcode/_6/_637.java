package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _637 {
    private List<Double> sum = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);

        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) * 1.0d / count.get(i));
        }
        return sum;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        int val = root.val;
        if (sum.size() > depth) {
            sum.set(depth, sum.get(depth) + val);
            count.set(depth, count.get(depth) + 1);
        } else {
            sum.add((double) val);
            count.add(1);
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
