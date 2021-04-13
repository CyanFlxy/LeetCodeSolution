package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.Node;

import java.util.ArrayList;
import java.util.List;

public class _589 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return result;
    }

//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//
//        List<Node> search = new LinkedList<>();
//        search.add(root);
//
//        while (!search.isEmpty()) {
//            Node node = search.remove(0);
//            result.add(node.val);
//            if (node.children != null) {
//                search.addAll(0, node.children);
//            }
//        }
//
//        return result;
//    }
}
