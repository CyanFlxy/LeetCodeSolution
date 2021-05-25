package com.cyanflxy.leetcode._9;

import java.util.PriorityQueue;

/**
 * @author cyanflxy
 * @since 2021.05.25
 */
public class _933 {
    class RecentCounter {
        private PriorityQueue<Integer> queue = new PriorityQueue<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            queue.offer(t);
            while (t - queue.peek() > 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
