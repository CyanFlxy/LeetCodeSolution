package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2020/9/11
 */
public class _1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0;
        while (candies >= index + 1) {
            result[index % num_people] += ++index;
            candies -= index;
        }
        result[index % num_people] += candies;
        return result;
    }
}
