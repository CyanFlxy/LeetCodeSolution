package com.cyanflxy.leetcode._5;

public class _541 {

    public String reverseStr(String s, int k) {
        if (k <= 1 || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += k * 2) {
            for (int j = Math.min(i + k - 1, len - 1); j >= i; j--) {
                sb.append(s.charAt(j));
            }
            for (int j = i + k; j < len && j < i + k * 2; j++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }

//    public String reverseStr(String s, int k) {
//        if (k <= 1) {
//            return s;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i += k * 2) {
//            String s1 = getSubString(s, i, i + k);
//            for (int j = s1.length() - 1; j >= 0; j--) {
//                sb.append(s1.charAt(j));
//            }
//
//            String s2 = getSubString(s, i + k, i + k * 2);
//            sb.append(s2);
//        }
//
//        return sb.toString();
//    }
//
//    private String getSubString(String s, int start, int end) {
//        if (start >= s.length()) {
//            return "";
//        }
//        if (end > s.length()) {
//            end = s.length();
//        }
//        return s.substring(start, end);
//    }
}
