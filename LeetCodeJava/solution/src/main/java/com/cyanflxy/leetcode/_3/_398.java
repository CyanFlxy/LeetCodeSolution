package com.cyanflxy.leetcode._3;

import java.util.Random;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _398 {
    class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            Random r = new Random();
            int index = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    count++;
                    if (r.nextInt() % count == 0) {
                        index = i;
                    }
                }
            }

            return index;
        }
    }
}
