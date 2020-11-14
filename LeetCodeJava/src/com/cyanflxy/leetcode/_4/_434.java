package com.cyanflxy.leetcode._4;

public class _434 {
    public static void main(String[] args) {
        String s = ", , , , a, eaefa";
    }

    public int countSegments(String s) {
        int count = 0;
        for (String str : s.split(" ")) {
            if (str.length() > 0) {
                count++;
            }
        }
        return count;
    }
}
