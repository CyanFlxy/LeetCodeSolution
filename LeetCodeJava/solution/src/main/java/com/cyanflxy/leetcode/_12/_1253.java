package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/5
 */
public class _1253 {

    public static void main(String... args) {
        new _1253().reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int count2 = 0;
        int allsum = 0;
        for (int i : colsum) {
            allsum += i;
            if (i == 2) {
                count2++;
            }
        }

        if (upper < count2 || lower < count2 || upper + lower != allsum) {
            return Collections.emptyList();
        }

        // 创建Array时提供一个初始大小，能将该算法从16s提升到12s
        List<Integer> upperList = new ArrayList<>(colsum.length);
        List<Integer> lowerList = new ArrayList<>(colsum.length);
        upper -= count2;
        lower -= count2;

        for (int i : colsum) {
            if (i == 2) {
                upperList.add(1);
                lowerList.add(1);
            } else if (i == 0) {
                upperList.add(0);
                lowerList.add(0);
            } else if (upper > 0) {
                upperList.add(1);
                lowerList.add(0);
                upper--;
            } else if (lower > 0) {
                upperList.add(0);
                lowerList.add(1);
                lower--;
            }
        }

        return Arrays.asList(upperList, lowerList);
    }

}
