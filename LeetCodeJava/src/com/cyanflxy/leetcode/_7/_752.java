package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.06.29
 */
public class _752 {
    public static void main(String[] args) {
        new _752().openLock(new String[]{}, "8888");
    }

    private static int SIGN = 10000;

    public int openLock(String[] deadends, String target) {
        int[] dp = new int[SIGN];
        Arrays.fill(dp, SIGN);
        int targetInt = parseInt(target);
        for (String de : deadends) {
            dp[parseInt(de)] = -1;
        }
        if (dp[0] == -1) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        dp[0] = 0;
        list.add(0);
        int step = 1;
        while (!list.isEmpty()) {
            List<Integer> list2 = new ArrayList<>();
            for (int i : list) {
                for (int x = 1; x <= 1000; x *= 10) {
                    int ia = next(i, x, true);
                    if (dp[ia] == SIGN) {
                        list2.add(ia);
                        dp[ia] = step;
                    }

                    int im = next(i, x, false);
                    if (dp[im] == SIGN) {
                        list2.add(im);
                        dp[im] = step;
                    }
                }
            }
            list = list2;
            step++;

            if (dp[targetInt] != SIGN) {
                return dp[targetInt];
            }
        }

        if (dp[targetInt] == SIGN) {
            return -1;
        } else {
            return dp[targetInt];
        }
    }

    private int parseInt(String str) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + str.charAt(i) - '0';
        }
        return result;
    }

    private int next(int i, int diff, boolean add) {
        int x = i / diff % 10;
        if (add) {
            if (x == 9) {
                return i - diff * 9;
            } else {
                return i + diff;
            }
        } else {
            if (x == 0) {
                return i + diff * 9;
            } else {
                return i - diff;
            }
        }
    }

}
