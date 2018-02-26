package com.cyanflxy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-72/problems/is-graph-bipartite/
 * Given a graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * <pre>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * </pre>
 * <pre>
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent ubsets.
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/26.
 */

public class _785_Is_Graph_Bipartite {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _785_Is_Graph_Bipartite object = new _785_Is_Graph_Bipartite();

        System.out.println(object.isBipartite(new int[][]{{4}, {}, {4}, {4}, {2, 3, 0}}));
    }

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        leftSet.add(0);

        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null || graph[i].length == 0) {
                continue;
            }

            if (!leftSet.contains(i) && !rightSet.contains(i)) {
                boolean inLeft = false;
                boolean inRight = false;

                for (int k = 0; k < graph[i].length; k++) {
                    int val = graph[i][k];
                    if (rightSet.contains(val)) {
                        inRight = true;
                        if (inLeft) {
                            return false;
                        }
                    } else if (leftSet.contains(val)) {
                        inLeft = true;
                        if (inRight) {
                            return false;
                        }
                    }
                }

                if (inLeft) {
                    rightSet.add(i);
                } else {
                    leftSet.add(i);
                }

            }

            if (leftSet.contains(i)) {
                for (int k = 0; k < graph[i].length; k++) {
                    int val = graph[i][k];
                    if (leftSet.contains(val)) {
                        return false;
                    } else {
                        rightSet.add(val);
                    }
                }
            } else if (rightSet.contains(i)) {
                for (int k = 0; k < graph[i].length; k++) {
                    int val = graph[i][k];
                    if (rightSet.contains(val)) {
                        return false;
                    }
                    leftSet.add(val);
                }
            }
        }

        return true;
    }
}
