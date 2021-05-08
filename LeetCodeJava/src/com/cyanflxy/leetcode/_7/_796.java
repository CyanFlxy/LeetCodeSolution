package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _796 {

    public static void main(String[] args) {
        new _796().rotateString("clrwmpkwru", "wmpkwruclr");
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        // 简单解法 (A+A).contains(B)

        if (A.equals(B)) {
            return true;
        }

        int len = A.length();
        int halfIndex = A.length() / 2;
        String half1 = A.substring(0, halfIndex);
        String half2 = A.substring(halfIndex);
        int index1 = B.indexOf(half1);
        int index2 = B.indexOf(half2);

        if (index1 < 0 && index2 < 0) {
            return false;
        }

        int ai, bi;
        if (index1 > 0) {
            ai = halfIndex;
            bi = index1 + halfIndex;
        } else {
            ai = 0;
            bi = index2 + halfIndex;
        }

        for (int i = 0; i < len - halfIndex; i++) {
            int a = (ai + i) % len;
            int b = (bi + i) % len;
            if (A.charAt(a) != B.charAt(b)) {
                return false;
            }
        }

        return true;
    }
}
