package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.07.19
 */
public class _822 {

    public static void main(String[] args) {
        new _822().flipgame(Utils.toArray(1, 2, 4, 4, 7), Utils.toArray(1, 3, 4, 1, 3));
    }

    public int flipgame(int[] fronts, int[] backs) {
        Boolean[] nums = new Boolean[2001];
        int max = 0;
        for (int i = 0; i < fronts.length; i++) {
            int f = fronts[i];
            int b = backs[i];
            if (f == b) {
                nums[f] = false;
            } else {
                if (nums[f] == null) {
                    nums[f] = true;
                    max = Math.max(max, f);
                }
                if (nums[b] == null) {
                    nums[b] = true;
                    max = Math.max(max, b);
                }
            }
        }

        for (int i = 1; i <= max; i++) {
            if (nums[i] != null && nums[i]) {
                return i;
            }
        }
        return 0;
    }
}
