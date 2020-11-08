package com.cyanflxy.leetcode._3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _354 {

    public static void main(String... args) {
        // [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
        // [[2,100],[3,200],[4,300],[5,250],[5,400],[5,500],[6,360],[6,370],[7,380]]
        int[][] env = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        int result = new _354().maxEnvelopes(env);
        System.out.println(result);

        // [[46,89],[50,53],[52,68],[72,45],[77,81]]
        // [0, 2, 1, 1, 0]
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        List<int[]> list = Arrays.asList(envelopes);

        Collections.sort(list, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            } else {
                return a1[0] - a2[0];
            }
        });

        int[] count = new int[list.size()];

        for (int i = list.size() - 2; i >= 0; i--) {
            int maxValue = 0;
            int[] curr = list.get(i);
            for (int j = i + 1; j < list.size() - maxValue; j++) {
                int[] target = list.get(j);
                if (curr[0] < target[0] && curr[1] < target[1] && count[j] + 1 > maxValue) {
                    maxValue = count[j] + 1;
                }
            }
            count[i] = maxValue;
        }

        int result = 0;
        for (int i = 0; i < count.length - result; i++) {
            if (count[i] > result) {
                result = count[i];
            }
        }

        return result + 1;
    }
}
