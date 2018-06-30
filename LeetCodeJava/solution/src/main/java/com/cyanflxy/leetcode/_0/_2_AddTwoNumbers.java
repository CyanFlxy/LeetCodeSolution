package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/ <br>
 * <p>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 * Created by XiaYuqiang on 2016/10/13.
 */
public class _2_AddTwoNumbers {

    private static ListNode create(int... values) {
        if (values == null) {
            return null;
        } else if (values.length == 1) {
            return new ListNode(values[0]);
        } else {
            int[] subValues = new int[values.length - 1];
            System.arraycopy(values, 1, subValues, 0, subValues.length);
            return new ListNode(values[0], create(subValues));
        }
    }

    public static void main(String... args) {
        ListNode l1 = create(5);
        ListNode l2 = create(5);
        ListNode result = new _2_AddTwoNumbers().addTwoNumbers(l1, l2);

        for (ListNode l = result; l != null; l = l.next) {
            System.out.print(l.val);
            if (l.next != null) {
                System.out.print("->");
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        ListNode preN1 = l1;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int overFlow = 0;

        for (; n1 != null && n2 != null; preN1 = n1, n1 = n1.next, n2 = n2.next) {

            n1.val += n2.val + overFlow;
            if (n1.val >= 10) {
                overFlow = 1;
                n1.val -= 10;
            } else {
                overFlow = 0;
            }

        }

        if (n1 == null) {
            preN1.next = n2;
        }

        while (overFlow == 1) {
            if (preN1.next == null) {
                preN1.next = new ListNode(1);
                break;
            } else {
                preN1 = preN1.next;
                preN1.val += 1;

                if (preN1.val >= 10) {
                    overFlow = 1;
                    preN1.val -= 10;
                } else {
                    break;
                }
            }
        }

        return l1;
    }

}
