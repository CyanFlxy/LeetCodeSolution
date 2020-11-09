package com.cyanflxy.leetcode._12;

/**
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _1262 {

    public static void main(String... args) {
        int result = new _1262().maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println(result);
    }

    public int maxSumDivThree(int[] nums) {
        int total = 0;

        int remain;
        int mr1_1 = 50000;
        int mr1_2 = 50000;
        int mr2_1 = 50000;
        int mr2_2 = 50000;

        for (int i : nums) {
            total += i;

            remain = i % 3;
            if (remain == 1) {
                if (i < mr1_2) {
                    if (i < mr1_1) {
                        mr1_2 = mr1_1;
                        mr1_1 = i;
                    } else {
                        mr1_2 = i;
                    }
                }
            } else if (remain == 2) {
                if (i < mr2_2) {
                    if (i < mr2_1) {
                        mr2_2 = mr2_1;
                        mr2_1 = i;
                    } else {
                        mr2_2 = i;
                    }
                }
            }
        }

        remain = total % 3;
        if (remain == 1) {
            if (mr1_1 < mr2_1 + mr2_2) {
                total -= mr1_1;
            } else {
                total = total - mr2_1 - mr2_2;
            }
        } else if (remain == 2) {
            if (mr2_1 < mr1_1 + mr1_2) {
                total -= mr2_1;
            } else {
                total = total - mr1_1 - mr1_2;
            }
        }

        return total < 0 ? 0 : total;
    }
}