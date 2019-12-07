package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/7
 */
public class _1247 {

    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int x1 = 0;
        int y1 = 0;

        // 转换成charArray后，速度要比直接从String中读取要快
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        for (int i = 0; i < n; i++) {
            char c1 = a1[i];
            if (c1 != a2[i]) {
                if (c1 == 'x') {
                    x1++;
                } else {
                    y1++;
                }
            }
        }

        if (((x1 + y1) & 1) == 1) {
            return -1;
        }

        return (x1 >> 1) + (y1 >> 1) + ((x1 & 1) << 1);
    }

}
