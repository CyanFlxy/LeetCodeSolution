package com.cyanflxy.leetcode.help;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/10/11
 */
public class Utils {

    public static List<Integer> toList(int... val) {
        List<Integer> result = new ArrayList<>();
        for (int i : val) {
            result.add(i);
        }
        return result;
    }

    public static List<String> toList(String... val) {
        List<String> result = new ArrayList<>();
        for (String s : val) {
            result.add(s);
        }
        return result;
    }
}
