package com.cyanflxy.leetcode._7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _710 {
    class Solution {
        private final int N;
        private int whiteCount;
        private final int blackCount;
        private int[] whiteList;
        private Set<Integer> blackSet;


        public Solution(int N, int[] blacklist) {
            this.N = N;
            blackCount = blacklist.length;

            if (blackCount > 0 && blackCount < N / 1000000) {
                blackSet = new HashSet<>();
                for (int n : blacklist) {
                    blackSet.add(n);
                }
                return;
            }

            if (blacklist.length > 0) {
                Arrays.sort(blacklist);
                int blackMax = blacklist[blackCount - 1];
                whiteCount = blackMax + 1 - blackCount;
                whiteList = new int[whiteCount];

                int bi = 0;
                int wi = 0;
                for (int i = 0; i < blackMax; i++) {
                    if (blacklist[bi] == i) {
                        bi++;
                    } else {
                        whiteList[wi++] = i;
                    }
                }

            } else {
                whiteCount = 0;
            }
        }

        public int pick() {
            if (blackSet != null) {
                int rand;
                while (true) {
                    rand = (int) (Math.random() * N);
                    if (!blackSet.contains(rand)) {
                        break;
                    }
                }
                return rand;
            }

            int rand = (int) (Math.random() * (N - blackCount));
            if (rand >= whiteCount) {
                return rand + blackCount;
            } else {
                return whiteList[rand];
            }
        }
    }
}
