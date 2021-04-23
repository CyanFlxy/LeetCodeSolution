package com.cyanflxy.leetcode._5;

import java.util.Arrays;
import java.util.Random;

public class _528 {
    class Solution {
        private int[] w;
        private int max;
        private Random random = new Random();

        public Solution(int[] w) {
            this.w = w;
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            max = w[w.length - 1];
        }

        public int pickIndex() {
            int r = random.nextInt(max);
            int arr = Arrays.binarySearch(w, r);
            return arr >= 0 ? arr + 1 : -arr - 1;
        }
    }
}
