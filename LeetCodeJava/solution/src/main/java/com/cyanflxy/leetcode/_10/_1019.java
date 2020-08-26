package com.cyanflxy.leetcode._10;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/21
 */
public class _1019 {

    public static void main(String... args) {
//        ListNode node = ListNode.create(10, 4, 6, 4, 10);
        ListNode node = ListNode.create(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1);
        new _1019().nextLargerNodes(node);
    }

    public int[] nextLargerNodes_copy(ListNode head) {
        int count = 0;
        ListNode n = head;
        while (n != null) {
            count++;
            n = n.next;
        }

        int[] result = new int[count];
        int[] stack = new int[count];
        int[] stackIndex = new int[count];
        int startIndex = -1;
        int index = 0;

        while (head != null) {
            int v = head.val;

            while (startIndex >= 0 && v > stack[startIndex]) {
                result[stackIndex[startIndex--]] = v;
            }

            stack[++startIndex] = v;
            stackIndex[startIndex] = index;

            head = head.next;
            index++;
        }
        return result;
    }

    // 速度最快的方案，3ms
    // 思路：将数据(i,v[i])记录下来，直到遇到下一个比v[i]大的数据
    // 如果没有遇到比v[i]大的数据，则将该数据压栈，下次遇到的时候，可以一起处理
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            count++;
        }

        int[] res = new int[count];
        int[] stack = new int[count];
        int[] si = new int[count];
        int index = 0;
        int startIndex = -1;

        while (head != null) {
            int t = head.val;
            while (startIndex >= 0 && t > stack[startIndex]) {
                res[si[startIndex--]] = t;
            }
            stack[++startIndex] = t;
            si[startIndex] = index;

            head = head.next;
            index++;
        }
        return res;
    }


    // Accept 使用数组替换ArrayList之后，速度提升至391ms，
    // 说明未知大小的ArrayList要比数组慢很多
    // 这里是典型的使用内存换cpu的情形
    public int[] nextLargerNodes_2(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int[] values = new int[10001];
        int count = 0;
        while (head != null) {
            values[count++] = head.val;
            head = head.next;
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int nextBig = 0;
            int current = values[i];
            for (int j = i + 1; j < count; j++) {
                if (values[j] > current) {
                    nextBig = values[j];
                    break;
                }
            }
            result[i] = nextBig;
        }

        return result;
    }


    // Accept 速度超级慢的方案，耗时1081ms
    public int[] nextLargerNodes_1(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>(64);
        int count = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            count++;
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int nextBig = 0;
            int current = list.get(i);
            for (int j = i + 1; j < count; j++) {
                if (list.get(j) > current) {
                    nextBig = list.get(j);
                    break;
                }
            }
            result[i] = nextBig;
        }


        return result;
    }
}
