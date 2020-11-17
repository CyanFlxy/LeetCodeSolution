package com.cyanflxy.leetcode._4;

import java.util.ArrayList;
import java.util.List;

public class _448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (n != nums[n - 1]) {
                int t = nums[n - 1];
                nums[n - 1] = n;
                n = t;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
