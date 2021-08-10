package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.08.10
 */
public class _0103 {

    public static void main(String[] args) {
        String result = new _0103().replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        System.out.println(result);
    }

    public String replaceSpaces(String S, int length) {
        char[] arr = S.toCharArray();
        int targetLen = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ') {
                targetLen += 3;
            } else {
                targetLen++;
            }
        }

        length--;
        for (int i = targetLen - 1; i >= 0 && length >= 0; length--) {
            if (arr[length] == ' ') {
                arr[i--] = '0';
                arr[i--] = '2';
                arr[i--] = '%';
            } else {
                arr[i--] = arr[length];
            }
        }

        return new String(arr, 0, targetLen);
    }
}
