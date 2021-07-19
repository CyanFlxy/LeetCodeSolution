package com.cyanflxy.leetcode.help;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/10/11
 */
public class Utils {

    public static <T> List<T> toList(T... val) {
        List<T> result = new ArrayList<>();
        for (T t : val) {
            result.add(t);
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

    public static int[] toArray(int... val) {
        return val;
    }

    public static String[] toArray(String... val) {
        return val;
    }
}
