package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _393 {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }

        for (int i = 0; i < data.length; ) {
            int count = dataCount(data[i]) - 1;
            if (count < 0) {
                return false;
            }
            i++;

            while (count > 0) {
                if (i >= data.length || !isSubData(data[i])) {
                    return false;
                }
                count--;
                i++;
            }

        }

        return true;
    }

    private int dataCount(int b) {
        if ((b & 0x80) == 0) {
            return 1;
        } else if ((b & 0xE0) == 0xC0) {
            return 2;
        } else if ((b & 0xF0) == 0xE0) {
            return 3;
        } else if ((b & 0xF8) == 0xF0) {
            return 4;
        } else {
            return 0;
        }
    }

    private boolean isSubData(int b) {
        return (b & 0xC0) == 0x80;
    }

}
