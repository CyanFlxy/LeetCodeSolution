package com.cyanflxy.leetcode._5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _519 {
    class Solution {
        private int row;
        private int col;
        private List<Integer> index;
        private Set<Integer> set;
        private boolean isBig;

        public Solution(int n_rows, int n_cols) {
            row = n_rows;
            col = n_cols;
            isBig = (row * col) > 10000;

            reset();
        }

        public int[] flip() {
            if (isBig) {
                if (set.size() == col * row) {
                    return null;
                }

                while (true) {
                    int i = (int) (Math.random() * col * row);
                    if (set.contains(i)) {
                        continue;
                    }
                    set.add(i);
                    return new int[]{i / col, i % col};
                }

            } else {
                if (index.size() == 0) {
                    return null;
                }

                int i;
                if (index.size() == 1) {
                    i = 0;
                } else {
                    i = (int) (Math.random() * index.size());
                }
                int result = index.get(i);
                index.remove(i);
                return new int[]{result / col, result % col};
            }
        }

        public void reset() {
            if (isBig) {
                if (set == null) {
                    set = new HashSet<>();
                } else {
                    set.clear();
                }
            } else {
                if (index == null) {
                    index = new ArrayList<>();
                } else {
                    index.clear();
                }
                for (int i = 0; i < row * col; i++) {
                    index.add(i);
                }
            }
        }
    }
}
