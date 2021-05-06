package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _720 {

    public static void main(String[] args) {
        String result = new _720().longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"});
        System.out.println(result);
    }

    public String longestWord(String[] words) {
        WordNode node = new WordNode();
        node.str = "";
        node.create();

        for (String word : words) {
            char[] arr = word.toCharArray();
            WordNode[] cur = node.list;
            for (int i = 0; i < arr.length; i++) {
                int ch = arr[i] - 'a';
                if (cur[ch] == null) {
                    cur[ch] = new WordNode();
                }

                if (i == arr.length - 1) {
                    cur[ch].str = word;
                } else {
                    cur[ch].create();
                    cur = cur[ch].list;
                }
            }
        }


        return dfs(node);
    }

    private String dfs(WordNode node) {
        if (node.list == null || node.str == null) {
            return node.str;
        }

        String max = node.str;
        for (WordNode n : node.list) {
            if (n == null || n.str == null) {
                continue;
            }
            String str = dfs(n);
            if (str.length() > max.length()) {
                max = str;
            }
        }
        return max;
    }

    static class WordNode {
        String str;
        WordNode[] list;

        void create() {
            if (list == null) {
                list = new WordNode[26];
            }
        }
    }
}
