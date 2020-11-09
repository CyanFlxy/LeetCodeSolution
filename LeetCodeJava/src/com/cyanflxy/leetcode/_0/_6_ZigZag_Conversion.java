package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <pre>
 * string convert(string text, int nRows);
 * </pre>
 * <p>
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * Created by cyanflxy on 2018/2/2.
 */

public class _6_ZigZag_Conversion {

    public static void main(String... args) {
        String str = "1234567890";
        String result = new _6_ZigZag_Conversion()
                .convert(str, 1);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows <= 1) {
            return s;
        }

        int length = s.length();
        char[] chs = s.toCharArray();
        int blockCount = numRows + numRows - 2;
        StringBuilder sb = new StringBuilder(length);

        // 第一行
        for (int index = 0; index < length; index += blockCount) {
            sb.append(chs[index]);
        }

        int maxEvenRow = numRows - 1;
        for (int row = 1; row < maxEvenRow; row++) {

            int offset = (numRows - row - 1) * 2;
            int maxLength = length - offset;
            int index = row;
            for (; index < maxLength; index += blockCount) {
                sb.append(chs[index]);
                sb.append(chs[index + offset]);
            }

            if (index < length) {
                sb.append(chs[index]);
            }
        }

        //最后一行
        for (int index = numRows - 1; index < length; index += blockCount) {
            sb.append(chs[index]);
        }

        return sb.toString();
    }
}
