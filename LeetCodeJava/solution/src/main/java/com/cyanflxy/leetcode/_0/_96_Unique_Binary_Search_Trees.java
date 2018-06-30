package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <pre>
 * Input: 3
 * Output:5
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 * </pre>
 * Created by cyanflxy on 2018/5/24.
 */

public class _96_Unique_Binary_Search_Trees {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _96_Unique_Binary_Search_Trees object = new _96_Unique_Binary_Search_Trees();
        System.out.println(object.numTrees(2));
    }

    private int[] values;

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        values = new int[n + 1];
        values[0] = 1;
        values[1] = 1;
        return getValueOf(n);
    }

    private int getValueOf(int index) {
        if (values[index] == 0) {
            int v = 0;

            for (int i = 0; i < index; i++) {
                v += getValueOf(i) * getValueOf(index - i - 1);
            }

            values[index] = v;
        }
        return values[index];
    }

}
