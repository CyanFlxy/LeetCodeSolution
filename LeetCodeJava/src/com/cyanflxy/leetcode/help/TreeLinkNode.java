package com.cyanflxy.leetcode.help;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2018/11/3
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static TreeLinkNode create(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeLinkNode head = new TreeLinkNode(values[0]);
        int index = 1;

        List<TreeLinkNode> nodesList = new ArrayList<>();
        List<TreeLinkNode> tempList = new ArrayList<>();
        nodesList.add(head);

        while (!nodesList.isEmpty()) {
            for (TreeLinkNode node : nodesList) {
                if (index < values.length && values[index] != null) {
                    node.left = new TreeLinkNode(values[index]);
                    tempList.add(node.left);
                }
                index++;

                if (index < values.length && values[index] != null) {
                    node.right = new TreeLinkNode(values[index]);
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
        TreeLinkNode node = create(1, 2, 3, 4, 5, 6, null, 8, 9);
        System.out.println(node);
    }
}
