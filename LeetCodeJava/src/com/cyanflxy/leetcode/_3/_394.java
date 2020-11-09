package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _394 {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int[] index = new int[1];

        for (int i = 0; i < arr.length; ) {
            char c = arr[i];
            if (c >= '0' && c <= '9') {
                index[0] = i;
                int count = getDigit(arr, index);
                String subStr = getSubString(arr, index);
                i = index[0];

                while (count > 0) {
                    count--;
                    sb.append(subStr);
                }

            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }

    private int getDigit(char[] arr, int[] index) {
        int result = 0;

        for (int i = index[0]; i < arr.length; i++) {
            char c = arr[i];
            if (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
            } else {
                index[0] = i;
                break;
            }
        }
        return result;
    }

    private String getSubString(char[] arr, int[] index) {
        StringBuilder sb = new StringBuilder();
        int subCount = 1;
        for (int i = index[0] + 1; i < arr.length; i++) {
            char c = arr[i];
            if (c == '[') {
                subCount++;
            } else if (c == ']') {
                subCount--;
                if (subCount == 0) {
                    index[0] = i + 1;
                    break;
                }
            }
            sb.append(c);
        }
        return decodeString(sb.toString());
    }
}
