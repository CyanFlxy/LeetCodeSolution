package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/description/
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <pre>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * </pre>
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * Created by cyanflxy on 2018/5/16.
 */

public class _89_Gray_Code {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _89_Gray_Code object = new _89_Gray_Code();

        System.out.println(object.grayCode(0));
        System.out.println(object.grayCode(1));
        System.out.println(object.grayCode(2));
        System.out.println(object.grayCode1(3));
    }

    public List<Integer> grayCode(int n) {
        int len = 1 << n;
        int[] result = new int[len];
        result[0] = 0;
        fillHalfArray(result, 0, len, false);

        List<Integer> list = new ArrayList<>();
        for (int i : result) {
            list.add(i);
        }

        return list;
    }

    private void fillHalfArray(int[] arr, int start, int end, boolean reverse) {
        int s;
        int e;
        final int half = (end - start) >> 1;

        if (half == 0) {
            return;
        }

        if (reverse) {
            s = start;
            e = start + half;
        } else {
            s = start + half;
            e = end;
        }

        for (int i = s; i < e; i++) {
            arr[i] |= half;
        }

        fillHalfArray(arr, start, start + half, false);
        fillHalfArray(arr, start + half, end, true);
    }

    // 这是什么鬼？
    public List<Integer> grayCode1(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }

        return result;
    }
}
