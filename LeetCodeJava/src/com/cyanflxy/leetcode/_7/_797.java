package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.13
 */
public class _797 {

    private List<List<Integer>> result = new ArrayList<>();
    private int N;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        N = graph.length;
        dfs(graph, new int[N], 0, 1);
        return result;
    }

    private void dfs(int[][] graph, int[] path, int gi, int pi) {
        if (gi == N - 1) {
            List<Integer> list = new ArrayList<>(N);
            for (int i = 0; i < pi; i++) {
                list.add(path[i]);
            }
            result.add(list);
            return;
        }

        int[] nexts = graph[gi];
        for (int n : nexts) {
            path[pi] = n;
            dfs(graph, path, n, pi + 1);
        }
    }
}
