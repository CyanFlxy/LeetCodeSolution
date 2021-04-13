package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.Node;

import java.util.ArrayList;
import java.util.List;

public class _590 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        result.add(root.val);
        return result;
    }
//
//    public List<Integer> postorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//
//        LinkedList<Node> search = new LinkedList<>();
//        search.add(root);
//        while (!search.isEmpty()) {
//            Node node = search.removeLast();
//            result.add(0, node.val);
//            search.addAll(node.children);
//        }
//
//        return result;
//    }
}
