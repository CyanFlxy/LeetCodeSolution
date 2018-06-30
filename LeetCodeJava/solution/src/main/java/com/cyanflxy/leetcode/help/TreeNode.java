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

    public static TreeNode create(Integer... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        int len = values.length;
        TreeNode[] nodeArray = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (values[i] != null) {
                nodeArray[i] = new TreeNode(values[i]);
            }
        }

        int level = 0;
        int index = 0;

        outer:
        do {
            int currentLevelEnd = index + (1 << level);
            int nextIndex = currentLevelEnd;

            for (int i = index; i < currentLevelEnd && i < len && nodeArray[i] != null; i++) {
                if (nextIndex >= len) {
                    break outer;
                }
                nodeArray[i].left = nodeArray[nextIndex];

                if (nextIndex + 1 >= len) {
                    break outer;
                }
                nodeArray[i].right = nodeArray[nextIndex + 1];

                nextIndex += 2;
            }
            index = currentLevelEnd;
            level++;
        } while (index < len);

        return nodeArray[0];
    }


    public static void main(String... args) {
        TreeNode node = create(1, 2, 3, 4, 5, 6, null, 8, 9);
        System.out.println(node);
    }
}
