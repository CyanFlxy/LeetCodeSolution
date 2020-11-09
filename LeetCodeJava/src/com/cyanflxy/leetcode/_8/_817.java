package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/26
 */
public class _817 {
    public int numComponents(ListNode head, int[] G) {
        // 先获取链表长度，再创建数组会更快一些。
        boolean[] table = new boolean[10000];
        for (int i : G) {
            table[i] = true;
        }

        int count = 0;

        while (head != null) {
            if (table[head.val] && (head.next == null || !table[head.next.val])) {
                count++;
            }

            head = head.next;
        }

        return count;
    }
}
