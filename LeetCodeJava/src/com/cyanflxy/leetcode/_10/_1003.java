package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2020/1/21
 */
public class _1003 {


    public boolean isValid(String S) {
        char[] a = new char[S.length()];
        int index = 0;
        char[] arr = S.toCharArray();

        for (char ch : arr) {
            if (ch == 'c') {
                if (index == 0 || a[--index] != 'b')
                    return false;
                if (index == 0 || a[--index] != 'a')
                    return false;
            } else {
                a[index++] = ch;
            }
        }
        return index == 0;

    }

    public boolean isValid1(String S) {
        int len;
        do {
            len = S.length();
            S = S.replace("abc", "");
        } while (S.length() < len);

        return S.length() == 0;
    }
}
