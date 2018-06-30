package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/permutation-sequence/description/
 * <p>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <ol>
 * <li>"123"</li>
 * <li>"132"</li>
 * <li>"213"</li>
 * <li>"231"</li>
 * <li>"312"</li>
 * <li>"321"</li>
 * </ol>
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 * <p>
 * Created by cyanflxy on 2018/3/14.
 */

public class _60_Permutation_Sequence {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _60_Permutation_Sequence object = new _60_Permutation_Sequence();
        System.out.println(object.getPermutation(3, 4));
//        System.out.println(object.getPermutation(3, 6));
//        System.out.println(object.getPermutation(9, 362879));
//        System.out.println(object.getPermutation(9, 345678));
    }

    private int[] FACTORIAL = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        getPermutation(sb, 0, n, k);

        return sb.toString();
    }

    public void getPermutation(StringBuilder sb, int s, int n, int k) {
        if (k == 1) {
            return;
        }

        if (k == FACTORIAL[n]) {
            int end = sb.length() - 1;
            int start = s;

            while (start < end) {
                change(sb, start, end);
                start++;
                end--;
            }
            return;
        }

        int index = k / FACTORIAL[n - 1];
        if (k % FACTORIAL[n - 1] == 0) {
            index--;
        }

        if (index > 0) {
            char ch = sb.charAt(s + index);
            sb.delete(s + index, s + index + 1);
            sb.insert(s, ch);
        }

        getPermutation(sb, s + 1, n - 1, k - FACTORIAL[n - 1] * index);
    }

    private void change(StringBuilder sb, int m, int n) {
        char ch = sb.charAt(m);
        sb.setCharAt(m, sb.charAt(n));
        sb.setCharAt(n, ch);
    }
}
