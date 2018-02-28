package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/count-and-say/description/
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <pre>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * </pre>
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <pre>
 * Input: 1
 * Output: "1"
 * </pre>
 * Example 2:
 * <pre>
 * Input: 4
 * Output: "1211"
 * </pre>
 * Created by cyanflxy on 2018/2/28.
 */

public class _38_Count_and_Say {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _38_Count_and_Say object = new _38_Count_and_Say();

        for (int i = 1; i < 8; i++) {
            System.out.println(object.countAndSay(i));
        }

        System.out.println(object.countAndSay(0).equals("1"));
        System.out.println(object.countAndSay(1).equals("1"));
        System.out.println(object.countAndSay(2).equals("11"));
        System.out.println(object.countAndSay(3).equals("21"));
        System.out.println(object.countAndSay(4).equals("1211"));
        System.out.println(object.countAndSay(5).equals("111221"));
        System.out.println(object.countAndSay(6).equals("312211"));
    }

    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");
        String source;

        for (int i = 2; i <= n; i++) {
            source = sb.toString();
            sb.setLength(0);

            char ch = 0;
            int count = 0;
            for (int k = 0; k < source.length(); k++) {
                if (ch == source.charAt(k)) {
                    count++;
                } else {
                    if (ch != 0) {
                        sb.append(count);
                        sb.append(ch);
                    }
                    ch = source.charAt(k);
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(ch);
        }

        return sb.toString();
    }
}
