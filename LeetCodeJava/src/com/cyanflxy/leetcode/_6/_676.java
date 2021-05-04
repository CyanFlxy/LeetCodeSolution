package com.cyanflxy.leetcode._6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.04
 */
public class _676 {

    class MagicDictionary {
        private String[] dictionary;

        public MagicDictionary() {
        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : dictionary) {
                if (isMagicWord(word, searchWord)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isMagicWord(String word, String target) {
            if (word.length() != target.length()) {
                return false;
            }

            int len = word.length();
            int diffCount = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != target.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) {
                        break;
                    }
                }
            }
            return diffCount == 1;
        }
    }

    class MagicDictionary2 {
        private Map<String, Map<String, Set<String>>> map;

        public MagicDictionary2() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String str : dictionary) {
                for (int i = 0; i < str.length(); i++) {
                    String head = str.substring(0, i);
                    String tail = str.substring(i + 1);
                    Map<String, Set<String>> mapped = map.computeIfAbsent(head, s -> new HashMap<>());
                    Set<String> set = mapped.computeIfAbsent(tail, s -> new HashSet<>());
                    set.add(str);
                }
            }
        }

        public boolean search(String searchWord) {
            for (int i = 0; i < searchWord.length(); i++) {
                String head = searchWord.substring(0, i);
                String tail = searchWord.substring(i + 1);
                if (map.containsKey(head)) {
                    Map<String, Set<String>> mapped = map.get(head);
                    if (mapped.containsKey(tail)) {
                        Set<String> set = mapped.get(tail);
                        if (!set.contains(searchWord) || set.size() > 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

}
