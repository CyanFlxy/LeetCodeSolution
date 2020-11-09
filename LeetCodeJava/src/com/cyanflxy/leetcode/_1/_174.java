package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2020/8/12
 */
public class _174 {

    public static void main(String... args) {
        int[][] val = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = new _174().calculateMinimumHP(val);
        System.out.println(result);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] bloodCount = new int[dungeon.length][dungeon[0].length];
        bloodCount[m - 1][n - 1] = Math.min(dungeon[m - 1][n - 1], 0);

        for (int j = n - 2; j >= 0; j--) {
            int d = dungeon[m - 1][j];
            int right = bloodCount[m - 1][j + 1];
            bloodCount[m - 1][j] = Math.min(d + right, 0);
        }

        for (int i = m - 2; i >= 0; i--) {
            int d = dungeon[i][n - 1];
            int bottom = bloodCount[i + 1][n - 1];
            bloodCount[i][n - 1] = Math.min(d + bottom, 0);

            for (int j = n - 2; j >= 0; j--) {
                d = dungeon[i][j];
                int right = bloodCount[i][j + 1];
                bottom = bloodCount[i + 1][j];

                bloodCount[i][j] = Math.min(Math.max(d + right, d + bottom), 0);
            }
        }

        return 1 - bloodCount[0][0];
    }

}
