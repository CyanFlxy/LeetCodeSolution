package com.cyanflxy.leetcode._1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/8/12
 */
public class _133 {


    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        List<Node> waitingList = new LinkedList<>();
        waitingList.add(node);
        while (!waitingList.isEmpty()) {
            Node origin = waitingList.remove(0);
            if (!nodeMap.containsKey(origin)) {
                Node copy = new Node(origin.val);
                nodeMap.put(origin, copy);
                waitingList.addAll(origin.neighbors);
            }
        }

        for (Map.Entry<Node, Node> pare : nodeMap.entrySet()) {
            List<Node> neighbors = pare.getKey().neighbors;
            if (neighbors != null && neighbors.size() > 0) {
                List<Node> copyNeighbor = pare.getValue().neighbors;
                for (Node n : neighbors) {
                    copyNeighbor.add(nodeMap.get(n));
                }
            }
        }

        return nodeMap.get(node);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
