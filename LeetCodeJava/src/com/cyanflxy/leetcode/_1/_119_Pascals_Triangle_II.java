package com.cyanflxy.leetcode._1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <pre>
 * Input: 3
 * Output: [1,3,3,1]
 * </pre>
 * <p>
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author cyanflxy
 * @since 2018/11/4
 */
public class _119_Pascals_Triangle_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _119_Pascals_Triangle_II object = new _119_Pascals_Triangle_II();
        System.out.println(object.getRow(0));
        System.out.println(object.getRow(1));
        System.out.println(object.getRow(2));
        System.out.println(object.getRow(3));
        System.out.println(object.getRow(4));
        System.out.println(object.getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        int[] a = new int[rowIndex + 1];
        int[] b = new int[rowIndex + 1];
        a[0] = 1;

        int[] cur = a;
        int[] last = b;

        for (int i = 1; i <= rowIndex; i++) {

            int[] t = cur;
            cur = last;
            last = t;

            cur[0] = 1;
            cur[1] = i;

            for (int j = 2; j < i; j++) {
                cur[j] = last[j] + last[j - 1];
            }

            cur[i] = 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i : cur) {
            result.add(i);
        }

        return result;
    }

}
