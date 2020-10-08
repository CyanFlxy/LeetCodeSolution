package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _1185 {
    public String dayOfTheWeek(int d, int m, int y) {
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }

        int week = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400 + 1) % 7;

        String[] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekday[week];
    }
}
