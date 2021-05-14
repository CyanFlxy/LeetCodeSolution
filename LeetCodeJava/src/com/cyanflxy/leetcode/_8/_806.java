package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.15
 */
public class _806 {
    public int[] numberOfLines(int[] widths, String s) {
        int currentLine = 0;
        int lineCount = 1;

        for (int ch : s.toCharArray()) {
            int w = widths[ch - 'a'];
            if (currentLine + w > 100) {
                lineCount++;
                currentLine = w;
            } else {
                currentLine += w;
            }
        }
        return new int[]{lineCount, currentLine};
    }
}
