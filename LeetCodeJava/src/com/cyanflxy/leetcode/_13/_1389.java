package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _1389 {
    public int[] createTargetArray(int[] nums, int[] index) {

        int[] target = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int idx = index[i];
            int n = nums[i];

            if (idx < i) {
                for (int j = i; j > idx; j--) {
                    target[j] = target[j - 1];
                }
            }

            target[idx] = n;
        }

        return target;

    }
}
