package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _508 {
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int maxCount = 0;
    private int resultCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] result = new int[resultCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int value = left + right + root.val;
        int count;
        if (countMap.containsKey(value)) {
            count = countMap.get(value) + 1;
        } else {
            count = 1;
        }

        countMap.put(value, count);
        if (maxCount < count) {
            resultCount = 1;
            maxCount = count;
        } else if (maxCount == count) {
            resultCount++;
        }
        return value;
    }
}
