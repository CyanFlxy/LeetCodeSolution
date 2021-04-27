package com.cyanflxy.leetcode._6;

import java.util.LinkedList;

public class _682 {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String str : ops) {
            switch (str) {
                case "+":
                    int i1 = list.pop();
                    int i2 = list.peek();
                    list.addFirst(i1);
                    list.addFirst(i1 + i2);
                    break;
                case "D":
                    list.addFirst(list.peek() * 2);
                    break;
                case "C":
                    list.removeFirst();
                    break;
                default:
                    list.addFirst(Integer.parseInt(str));
                    break;
            }
        }

        int result = 0;
        for (int i : list) {
            result += i;
        }
        return result;
    }
}
