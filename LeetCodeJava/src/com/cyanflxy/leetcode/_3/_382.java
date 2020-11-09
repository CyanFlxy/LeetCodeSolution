package com.cyanflxy.leetcode._3;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.Random;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _382 {
    class Solution {

        private ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            Random r = new Random();
            ListNode node = head;
            int value = 0;
            int count = 0;
            while (node != null) {
                count++;
                if (r.nextInt() % count == 0) {
                    value = node.val;
                }
                node = node.next;
            }
            return value;
        }
    }
}
