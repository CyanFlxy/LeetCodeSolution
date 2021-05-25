package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2021.05.26
 */
public class _1190 {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < arr.length; ) {
            if (arr[i] == '(') {
                int end = reverse(arr, i, len);
                i = end + 1;
            } else {
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private int reverse(char[] arr, int from, int len) {
        int end = 0;
        for (int i = from + 1; i < len; i++) {
            if (arr[i] == '(') {
                reverse(arr, i, len);
            } else if (arr[i] == ')') {
                end = i;
                break;
            }
        }

        arr[from] = 0;
        arr[end] = 0;
        for (int i = from + 1, j = end - 1; i < j; i++, j--) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
        return end;
    }

}
