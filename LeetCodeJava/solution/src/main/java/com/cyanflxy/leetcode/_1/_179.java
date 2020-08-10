package com.cyanflxy.leetcode._1;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/8/10
 */
public class _179 {

    public static void main(String... args) {
//        new _179().largestNumber(new int[]{1, 2, 231, 523, 82, 9, 10, 12, 123});
        new _179().largestNumber(new int[]{121, 12,});
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String i : strs) {
            sb.append(i);
        }
        return sb.toString();
    }

}
