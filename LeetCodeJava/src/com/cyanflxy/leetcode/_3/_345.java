package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i <= j && !isVowel(arr[i])) {
                i++;
            }
            while (j >= i && !isVowel(arr[j])) {
                j--;
            }
            if (i < j && arr[i] != arr[j]) {
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            i++;
            j--;
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = Character.toLowerCase(c);
        }
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
