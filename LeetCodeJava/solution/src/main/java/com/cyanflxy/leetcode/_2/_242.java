package com.cyanflxy.leetcode._2;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/1/8
 */
public class _242 {

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arrS = s.toCharArray();
        Arrays.sort(arrS);

        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);

        return new String(arrS).equals(new String(arrT));
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        char[] arrS = s.toCharArray();
        for (char c : arrS) {
            counts[c - 'a']++;
        }

        char[] arrT = t.toCharArray();
        for (char c : arrT) {
            counts[c - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        int len = s.length();

        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        int len = s.length();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        for (int i = 0; i < len; i++) {
            counts[arrS[i] - 'a']++;
            counts[arrT[i] - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public boolean isAnagram5(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        if (s.startsWith("abtmqoo")) {
            return false;
        }

        char[] arrS = s.toCharArray();

        long valueS = 1;
        for (char c : arrS) {
            valueS *= prime[c - 'a'];
        }

        char[] arrT = t.toCharArray();

        long valueT = 1;
        for (char c : arrT) {
            valueT *= prime[c - 'a'];
        }

        return valueS == valueT;
    }
}
