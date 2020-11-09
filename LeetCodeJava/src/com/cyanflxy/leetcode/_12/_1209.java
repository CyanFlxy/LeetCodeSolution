package com.cyanflxy.leetcode._12;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _1209 {
    public int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }

        return result;
    }
}
