package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2020/9/4
 */
public class _1154 {

    public int dayOfYear(String date) {
        int[] days = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int mon = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int result = days[mon] + day;
        if (mon > 2) {
            int year = Integer.parseInt(date.substring(0, 4));
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                result++;
            }
        }

        return result;
    }
}
