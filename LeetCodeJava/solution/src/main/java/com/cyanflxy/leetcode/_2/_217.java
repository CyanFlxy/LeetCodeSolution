package com.cyanflxy.leetcode._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _217 {
    // 先排序会更快！！
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
}
