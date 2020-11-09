package com.cyanflxy.leetcode.offer;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        int count = 0;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
            count++;
        }

        int[] result = new int[count];

        head = pre;
        pre = null;
        int i = 0;
        while (head != null) {
            result[i++] = head.val;
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return result;
    }

    public int[] reversePrint2(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }

        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
