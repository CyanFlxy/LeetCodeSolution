package com.cyanflxy.leetcode._8;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.06.02
 */
public class _881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int m = people.length - 1;
        int count = 0;

        while (l < m) {
            if (people[m] + people[l] <= limit) {
                l++;
            }
            m--;
            count++;
        }
        if (l == m) {
            count++;
        }
        return count;
    }


}
