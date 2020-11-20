package com.cyanflxy.leetcode._4;

public class _423 {

    public static void main(String[] args) {
        String s = " one  three  five  seven  nine";
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                count[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i) + " " + count[i]);
        }
    }

    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                count[c - 'a']++;
            }
        }

        int[] numCount = new int[10];
        numCount[0] = count['z' - 'a'];
        numCount[2] = count['w' - 'a'];
        numCount[4] = count['u' - 'a'];
        numCount[6] = count['x' - 'a'];
        numCount[8] = count['g' - 'a'];

        numCount[1] = count['o' - 'a'] - numCount[0] - numCount[2] - numCount[4];
        numCount[3] = count['h' - 'a'] - numCount[8];
        numCount[5] = count['f' - 'a'] - numCount[4];
        numCount[7] = count['s' - 'a'] - numCount[6];

        numCount[9] = count['i' - 'a'] - numCount[5] - numCount[6] - numCount[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
