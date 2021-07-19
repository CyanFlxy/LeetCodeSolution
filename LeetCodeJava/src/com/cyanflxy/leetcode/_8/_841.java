package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.07.19
 */
public class _841 {

    public static void main(String[] args) {
        //noinspection unchecked
        List<List<Integer>> rooms = Utils.toList(
                Utils.toList(1),
                Utils.toList(2),
                Utils.toList(3),
                Utils.toList(0)
        );
        boolean result = new _841().canVisitAllRooms(rooms);
        System.out.println(result);
    }


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> next = new ArrayList<>();
        next.add(0);

        while (!next.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : next) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                tmp.addAll(rooms.get(i));
            }
            next = tmp;
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
