package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <pre>
 * [
 *      ["ate", "eat","tea"],
 *      ["nat","tan"],
 *      ["bat"]
 * ]
 * </pre>
 * Note: All inputs will be in lower-case.
 * <p>
 * Created by cyanflxy on 2018/3/8.
 */

public class _49_Group_Anagrams {


    public static void main(String... args) {
        test();
    }

    private static void test() {
        _49_Group_Anagrams object = new _49_Group_Anagrams();
        System.out.println(object.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();

            int value = 1;
            for (char c : arr) {
                value *= prime[c - 'a'];
            }

            List<String> list = map.get(value);
            if (list == null) {
                list = new ArrayList<>();
                map.put(value, list);
            }
            list.add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
