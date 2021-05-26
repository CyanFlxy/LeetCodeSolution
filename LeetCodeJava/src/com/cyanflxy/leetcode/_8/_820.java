package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.05.26
 */
public class _820 {

    public static void main(String[] args) {
        int result = new _820().minimumLengthEncoding(Utils.toArray("a"));
        result = new _820().minimumLengthEncoding(Utils.toArray("time", "atime", "btime"));
        System.out.println(result);
    }

    private int result;

    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word, word.length() - 1);
        }

        dfs(trie, 0);
        return result;
    }

    private void dfs(Trie trie, int deep) {
        if (trie.next == null) {
            result += deep + 1;
        } else {
            for (Trie t : trie.next) {
                if (t != null) {
                    dfs(t, deep + 1);
                }
            }
        }
    }

    class Trie {
        Trie[] next;

        void add(String str, int i) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (next == null) {
                next = new Trie[26];
            }
            if (next[index] == null) {
                next[index] = new Trie();
            }
            if (i > 0) {
                next[index].add(str, i - 1);
            }
        }

    }
}
