package com.cyanflxy.leetcode._9;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/11/9
 */
public class _973 {
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (p, q) -> p[0] * p[0] + p[1] * p[1] - q[0] * q[0] - q[1] * q[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

}
