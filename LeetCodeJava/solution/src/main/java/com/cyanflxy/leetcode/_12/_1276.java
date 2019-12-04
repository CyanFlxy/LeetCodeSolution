package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/4
 */
public class _1276 {

    public static void main(String... args) {
        List<Integer> result = new _1276().numOfBurgers(16, 7);
        System.out.println(result);
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if ((tomatoSlices & 0x1) != 0) {
            return result;
        }

        tomatoSlices >>= 1;

        if (tomatoSlices >= cheeseSlices
                && tomatoSlices <= (cheeseSlices << 1)) {
            int jumbo = tomatoSlices - cheeseSlices;
            result.add(jumbo);
            result.add(cheeseSlices - jumbo);
        }

        return result;
    }

}
