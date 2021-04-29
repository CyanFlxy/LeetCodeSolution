package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _611 {

    public int triangleNumber(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < len - 2; i++) {
            int a = nums[i];
            if (a == 0) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                int b = nums[j];
                if (b == 0) {
                    continue;
                }

                int min = Math.abs(a - b);
                int max = a + b;

                for (int k = j + 1; k < len; k++) {
                    int c = nums[k];
                    if (min < c && c < max) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

}
