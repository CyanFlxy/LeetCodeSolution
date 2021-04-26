package com.cyanflxy.leetcode._6;

public class _657 {
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;

        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    h++;
                    break;
                case 'D':
                    h--;
                    break;
                case 'L':
                    v--;
                    break;
                case 'R':
                    v++;
                    break;
            }
        }

        return h == 0 && v == 0;
    }
}
