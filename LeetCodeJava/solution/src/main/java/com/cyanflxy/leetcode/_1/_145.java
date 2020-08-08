package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _145 {

    public static void main(String... args) {
        TreeNode node = TreeNode.create(1, 4, 3, 2);
        new _145().postorderTraversal(node);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            postorderTraversal(root.left, list);
        }
        if (root.right != null) {
            postorderTraversal(root.right, list);
        }

        list.add(root.val);
    }

}
