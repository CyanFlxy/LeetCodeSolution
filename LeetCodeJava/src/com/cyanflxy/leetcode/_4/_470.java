package com.cyanflxy.leetcode._4;

public class _470 {

    public int rand10() {
        int r1, r2, idx;
        do {
            r1 = rand7();
            r2 = rand7();
            idx = (r1 - 1) * 7 + r2;
        } while (idx > 40);

        return idx % 10 + 1;
    }

    public int rand7() {
        return 1;
    }
}
