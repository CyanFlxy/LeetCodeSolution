package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/decode-ways/description/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <pre>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * </pre>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <pre>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * </pre>
 * Example 2:
 * <pre>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * </pre>
 * Created by cyanflxy on 2018/5/21.
 */
public class _91_Decode_Ways {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _91_Decode_Ways object = new _91_Decode_Ways();

        System.out.println(object.numDecodings(""));
        System.out.println(object.numDecodings("1"));
        System.out.println(object.numDecodings("12"));
        System.out.println(object.numDecodings("226"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;
        int p1 = 1;
        int p2 = 1;

        for (int i = 1; i < len; i++) {
            int t = 0;
            char cur = arr[i];
            char pre = arr[i - 1];

            if (cur != '0') {
                t += p1;
            }

            if (pre == '1' || (pre == '2' && cur <= '6')) {
                t += p2;
            }

            p2 = p1;
            p1 = t;
        }

        return p1;
    }

    // 递归法
    private int numbDecodings(String s, int start) {
        if (start == s.length()) {
            return 1;
        }

        char cur = s.charAt(start);

        if (cur >= '3') {
            return numbDecodings(s, start + 1);

        } else if (cur == '1' || cur == '2') {

            if (start + 1 == s.length()) {
                return 1;
            }

            char next = s.charAt(start + 1);
            if (next == '0') {
                return numbDecodings(s, start + 2);
            } else if (cur == '1' || next <= '6') {
                return numbDecodings(s, start + 1) + numbDecodings(s, start + 2);
            } else {
                return numbDecodings(s, start + 1);
            }

        } else {
            // error
            return 0;
        }

    }
}
