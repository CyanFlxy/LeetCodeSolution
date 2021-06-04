package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.06.04
 */
public class _944 {
    public int minDeletionSize(String[] strs) {
        if (strs.length <= 1) {
            return 0;
        }

        int len = strs[0].length();
        boolean[] delete = new boolean[len];
        int count = 0;

        for (int i = 1; i < strs.length; i++) {
            String last = strs[i - 1];
            String cur = strs[i];

            for (int j = 0; j < len; j++) {
                if (!delete[j]) {
                    if (cur.charAt(j) < last.charAt(j)) {
                        delete[j] = true;
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
