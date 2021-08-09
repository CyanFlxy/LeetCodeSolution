package com.cyanflxy.leetcode.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.08.09
 */
public class _1010 {
    public static void main(String[] args) {

        StreamRank rank = new _1010().new StreamRank();
        rank.track(4);
        rank.track(3);
        rank.track(5);
        rank.track(3);
        rank.track(1);
        rank.track(5);

        System.out.println(rank.getRankOfNumber(3));
        System.out.println(rank.getRankOfNumber(5));
    }

    class StreamRank {
        private List<Integer> list = new ArrayList<>();

        public StreamRank() {
        }

        public void track(int x) {
            list.add(x);
            Collections.sort(list);
        }

        public int getRankOfNumber(int x) {
            int result = Collections.binarySearch(list, x);
            return result >= 0 ? getLastIndex(result, x) + 1 : -result - 1;
        }

        private int getLastIndex(int index, int target) {
            while (index < list.size() - 1 && list.get(index + 1) == target) {
                index++;
            }
            return index;
        }
    }
}
