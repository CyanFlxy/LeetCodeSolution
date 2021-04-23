package com.cyanflxy.leetcode._5;

import java.util.Arrays;
import java.util.List;

public class _539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) {
            return 0;
        }

        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            arr[i] = getTimeMinute(timePoints.get(i));
        }

        Arrays.sort(arr);

        int min = 1440;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        min = Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);

        return min;
    }

    private int getTimeMinute(String time) {
        int h = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int m = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        return h * 60 + m;
    }
}
