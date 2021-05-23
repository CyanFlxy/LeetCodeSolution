package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.05.23
 */
public class _208 {
    class Trie {

        Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node last = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                last = last.getNode(ch - 'a');
            }
            last.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node last = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node next = last.next[ch - 'a'];
                if (next == null) {
                    return false;
                }
                last = next;
            }
            return last.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node last = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                Node next = last.next[ch - 'a'];
                if (next == null) {
                    return false;
                }
                last = next;
            }
            return true;
        }

        class Node {
            boolean end = false;
            Node[] next = new Node[26];

            Node getNode(int index) {
                if (next[index] == null) {
                    next[index] = new Node();
                }
                return next[index];
            }
        }
    }

}
