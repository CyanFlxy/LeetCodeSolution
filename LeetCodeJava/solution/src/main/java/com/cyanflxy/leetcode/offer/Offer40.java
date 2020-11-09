package com.cyanflxy.leetcode.offer;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/11/9
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
