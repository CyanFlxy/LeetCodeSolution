package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.27
 */
public class _838 {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int lastR = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'R') {
                if (lastR >= 0) {
                    for (int j = lastR + 1; j < i; j++) {
                        arr[j] = 'R';
                    }
                }
                lastR = i;
            } else if (c == 'L') {
                if (lastR < 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] == '.') {
                            arr[j] = 'L';
                        } else {
                            break;
                        }
                    }
                } else {
                    for (int j = lastR + 1, k = i - 1; j < k; j++, k--) {
                        arr[j] = 'R';
                        arr[k] = 'L';
                    }
                }
                lastR = -1;
            }
        }

        if (lastR >= 0) {
            for (int i = lastR + 1; i < arr.length; i++) {
                arr[i] = 'R';
            }
        }

        return new String(arr);
    }
}
