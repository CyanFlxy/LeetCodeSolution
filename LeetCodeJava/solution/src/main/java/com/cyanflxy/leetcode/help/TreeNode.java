package com.cyanflxy.leetcode.help;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String cur = val + " ";

        String left = "";
        if (this.left != null) {
            left = this.left.toString();
        }

        String right = "";
        if (this.right != null) {
            right = this.right.toString();
        }

        return cur + left + " " + right;
    }
}
