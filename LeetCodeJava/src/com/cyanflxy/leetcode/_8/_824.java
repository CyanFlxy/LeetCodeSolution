package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _824 {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sufix = new StringBuilder();
        sufix.append('a');

        for (String str : S.split(" ")) {
            if (isStartVowel(str)) {
                sb.append(str).append("ma").append(sufix);
            } else {
                sb.append(str.substring(1)).append(str.charAt(0)).append("ma").append(sufix);
            }
            sb.append(' ');
            sufix.append('a');
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean isStartVowel(String str) {
        char ch = str.charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            ch += 'a' - 'A';
        }
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }
}
