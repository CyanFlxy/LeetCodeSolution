package com.cyanflxy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 问题1： 可以使用质数计算字符串的hash（每个字母代表一个质数，所有质数相乘则得到一个单独的hash）
    // 最后的结果收集可以在运行中做 - 每创建一个Array，则添加一次。
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);

            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sorted, list);
            }
            list.add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
