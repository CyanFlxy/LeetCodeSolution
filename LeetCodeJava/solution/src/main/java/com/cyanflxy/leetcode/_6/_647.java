package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/8/21
 */
public class _647 {

    // Manacher(马拉车)算法
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder("^#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");

        n = sb.length() - 1;

        int maxC = 0;
        int maxR = 0;
        int[] r = new int[n];
        r[0] = 1;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            r[i] = maxR >= i ? Math.min(r[2 * maxC - i], maxR - i + 1) : 1;

            while (sb.charAt(i - r[i]) == sb.charAt(i + r[i])) {
                r[i]++;
            }

            if (i + r[i] - 1 > maxR) {
                maxR = i + r[i] - 1;
                maxC = i;
            }

            ans += r[i] / 2;
        }


        return ans;
    }

}
