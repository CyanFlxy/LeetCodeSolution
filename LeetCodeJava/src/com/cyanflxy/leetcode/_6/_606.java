package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.TreeNode;

public class _606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t != null) {
            tree2str(t, sb);
        }
        return sb.toString();
    }

    public void tree2str(TreeNode node, StringBuilder sb) {
        sb.append(node.val);

        if (node.left != null) {
            sb.append("(");
            tree2str(node.left, sb);
            sb.append(")");
        } else {
            if (node.right != null) {
                sb.append("()");
            }
        }

        if (node.right != null) {
            sb.append("(");
            tree2str(node.right, sb);
            sb.append(")");
        }
    }
}
