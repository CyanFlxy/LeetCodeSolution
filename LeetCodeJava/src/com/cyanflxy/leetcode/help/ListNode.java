package com.cyanflxy.leetcode.help;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode n) {
        val = x;
        next = n;
    }

    @Override
    public String toString() {
        return val + (next != null ? "->" + next.toString() : ";");
//        return "" + val;
    }

    public static ListNode create(int... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode pre = result;
        for (int i : vals) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        return result.next;
    }
}
