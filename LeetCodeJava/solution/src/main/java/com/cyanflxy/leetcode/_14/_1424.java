package com.cyanflxy.leetcode._14;

import com.cyanflxy.leetcode.help.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/10/11
 */
public class _1424 {
    public static void main(String... args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Utils.toList(1, 2, 3, 4, 5));
        nums.add(Utils.toList(6, 7));
        nums.add(Utils.toList(8));
        nums.add(Utils.toList(9, 10, 11));
        nums.add(Utils.toList(12, 13, 14, 15, 16));
        int[] result = new _1424().findDiagonalOrder(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        Node head = new Node();
        Node current = head;

        for (List<Integer> list : nums) {
            count += list.size();
            Node node = new Node();
            node.value = list;
            node.prev = current;
            current.next = node;
            current = node;
        }

        head = head.next;
        head.prev = null;

        Node last = new Node();
        last.prev = current;
        current.next = last;

        int[] result = new int[count];
        int index = 0;

        while (last.prev != null) {
            Node n = head.next;

            while (n != null && n.prev != null) {
                Node p = n.prev;
                if (p.value.size() > p.index) {
                    result[index++] = p.value.get(p.index++);
                    n = n.prev;
                } else {
                    n.prev = p.prev;
                }
            }

            if (head.next != last) {
                head = head.next;
            }
        }

        return result;
    }

    class Node {
        List<Integer> value;
        int index;
        Node prev;
        Node next;
    }


    // 速度较慢
    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
        List<Integer> cache = new ArrayList<>();

        List<Iterator<Integer>> iteratorList = new ArrayList<>();
        iteratorList.add(nums.get(0).iterator());
        int line = 1;

        while (!iteratorList.isEmpty()) {

            List<Iterator<Integer>> deleteList = new ArrayList<>();
            for (int i = iteratorList.size() - 1; i >= 0; i--) {
                Iterator<Integer> iterator = iteratorList.get(i);
                if (iterator.hasNext()) {
                    cache.add(iterator.next());
                } else {
                    deleteList.add(iterator);
                }
            }
            iteratorList.removeAll(deleteList);

            if (line < nums.size()) {
                iteratorList.add(nums.get(line).iterator());
                line++;
            }
        }

        int[] result = new int[cache.size()];
        for (int i = 0; i < cache.size(); i++) {
            result[i] = cache.get(i);
        }
        return result;
    }


}
