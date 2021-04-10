package com.cyanflxy.leetcode._5;

public class _520 {

    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if (Character.isUpperCase(arr[0])) {
            int upper = 1;
            for (int i = 1; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    upper++;
                }
            }
            return upper == 1 || upper == arr.length - 1;
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
