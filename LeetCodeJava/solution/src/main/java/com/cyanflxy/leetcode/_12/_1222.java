package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/11
 */
public class _1222 {

    public static void main(String... args) {
        List<List<Integer>> result = new _1222().queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0});
        System.out.println(result);
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int li = -1, ri = -1, ti = -1, bi = -1, lti = -1, rbi = -1, rti = -1, lbi = -1;
        int ld = 10, rd = 10, td = 10, bd = 10, ltd = 10, rbd = 10, rtd = 10, lbd = 10;

        int kx = king[0];
        int ky = king[1];

        for (int i = 0; i < queens.length; i++) {
            int x = queens[i][0];
            int y = queens[i][1];

            if (x == kx) {
                if (y < ky) {
                    if ((ky - y) < ld) {
                        ld = ky - y;
                        li = i;
                    }
                } else {
                    if (y - ky < rd) {
                        rd = y - ky;
                        ri = i;
                    }
                }

            } else if (y == ky) {

                if (x < kx) {
                    if (kx - x < td) {
                        td = kx - x;
                        ti = i;
                    }
                } else {
                    if (x - kx < bd) {
                        bd = x - kx;
                        bi = i;
                    }
                }

            } else if (x - kx == y - ky) {
                // 左上-右下
                if (x < kx) {
                    if (kx - x < ltd) {
                        ltd = kx - x;
                        lti = i;
                    }
                } else {
                    if (x - kx < rbd) {
                        rbd = x - kx;
                        rbi = i;
                    }
                }

            } else if (x - kx == ky - y) {
                // 左下-右上
                if (x < kx) {
                    if (kx - x < lbd) {
                        lbd = kx - x;
                        lbi = i;
                    }
                } else {
                    if (x - kx < rtd) {
                        rtd = x - kx;
                        rti = i;
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        if (li >= 0) {
            result.add(Arrays.asList(queens[li][0], queens[li][1]));
        }
        if (ri >= 0) {
            result.add(Arrays.asList(queens[ri][0], queens[ri][1]));
        }
        if (ti >= 0) {
            result.add(Arrays.asList(queens[ti][0], queens[ti][1]));
        }
        if (bi >= 0) {
            result.add(Arrays.asList(queens[bi][0], queens[bi][1]));
        }
        if (lti >= 0) {
            result.add(Arrays.asList(queens[lti][0], queens[lti][1]));
        }
        if (rbi >= 0) {
            result.add(Arrays.asList(queens[rbi][0], queens[rbi][1]));
        }
        if (rti >= 0) {
            result.add(Arrays.asList(queens[rti][0], queens[rti][1]));
        }
        if (lbi >= 0) {
            result.add(Arrays.asList(queens[lbi][0], queens[lbi][1]));
        }

        return result;
    }
}
