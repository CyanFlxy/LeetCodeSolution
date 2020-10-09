package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/10/9
 */
public class _953 {

    public static void main(String... args) {
        new _953().isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz");
    }

    public boolean isAlienSorted(String[] words, String order) {
        String[] trans = new String[words.length];
        char[] dic = new char[26];
        for (int i = 0; i < 26; i++) {
            dic[order.charAt(i) - 'a'] = (char) ('a' + i);
        }

        for (int i = 0; i < words.length; i++) {
            String src = words[i];
            char[] dest = new char[src.length()];
            for (int j = 0; j < src.length(); j++) {
                dest[j] = dic[src.charAt(j) - 'a'];
            }
            trans[i] = new String(dest);
        }

        for (int i = 1; i < trans.length; i++) {
            if (trans[i].compareTo(trans[i - 1]) < 0) {
                return false;
            }
        }

        return true;
    }

}
