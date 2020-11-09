package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/9/4
 */
public class _257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, new StringBuilder(), result);
        }
        return result;
    }

    private void dfs(TreeNode root, StringBuilder pre, List<String> result) {
        if (pre.length() > 0) {
            pre.append("->");
        }
        pre.append(root.val);

        if (root.left != null || root.right != null) {
            if (root.left != null) {
                dfs(root.left, new StringBuilder(pre), result);
            }
            if (root.right != null) {
                dfs(root.right, new StringBuilder(pre), result);
            }
        } else {
            result.add(pre.toString());
        }
    }
}
