package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _501 {
    private int lastValue = Integer.MAX_VALUE;
    private int maxCount = 1;
    private int currentCount = 0;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        if (lastValue != Integer.MAX_VALUE) {
            if (currentCount == maxCount) {
                result.add(lastValue);
            } else if (currentCount > maxCount) {
                maxCount = currentCount;
                result.clear();
                result.add(lastValue);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);

        if (root.val == lastValue) {
            currentCount++;
        } else {
            if (lastValue != Integer.MAX_VALUE) {
                if (currentCount == maxCount) {
                    result.add(lastValue);
                } else if (currentCount > maxCount) {
                    maxCount = currentCount;
                    result.clear();
                    result.add(lastValue);
                }
            }

            currentCount = 1;
            lastValue = root.val;
        }

        inOrderTraversal(root.right);
    }
}
