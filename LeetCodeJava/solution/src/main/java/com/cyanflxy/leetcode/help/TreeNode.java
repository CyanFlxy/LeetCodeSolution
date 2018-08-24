package com.cyanflxy.leetcode.help;

import java.util.ArrayList;
import java.util.List;

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

    public static TreeNode create(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode head = new TreeNode(values[0]);
        int index = 1;

        List<TreeNode> nodesList = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        nodesList.add(head);

        while (!nodesList.isEmpty()) {
            for (TreeNode node : nodesList) {
                if (index < values.length && values[index] != null) {
                    node.left = new TreeNode(values[index]);
                    tempList.add(node.left);
                }
                index++;

                if (index < values.length && values[index] != null) {
                    node.right = new TreeNode(values[index]);
                    tempList.add(node.right);
                }
                index++;
            }
            nodesList = tempList;
            tempList = new ArrayList<>();
        }

        return head;
    }


    public static void main(String... args) {
        TreeNode node = create(1, 2, 3, 4, 5, 6, null, 8, 9);
        System.out.println(node);
    }
}
