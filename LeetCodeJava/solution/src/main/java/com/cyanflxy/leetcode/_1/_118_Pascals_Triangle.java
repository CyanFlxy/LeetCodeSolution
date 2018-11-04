package com.cyanflxy.leetcode._1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author cyanflxy
 * @since 2018/11/4
 */
public class _118_Pascals_Triangle {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _118_Pascals_Triangle object = new _118_Pascals_Triangle();
        System.out.println(object.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastList = null;

        for (int i = 1; i <= numRows; i++) {
            lastList = generateNextList(lastList);
            result.add(lastList);
        }

        return result;
    }

    private List<Integer> generateNextList(List<Integer> current) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        if (current != null) {

            for (int i = 1; i < current.size(); i++) {
                result.add(current.get(i) + current.get(i - 1));
            }

            result.add(1);
        }

        return result;
    }
}
