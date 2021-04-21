package com.cyanflxy.leetcode._5;

public class _576 {
    public static void main(String[] args) {
        int result = new _576().findPaths(8, 50, 23, 5, 26);
        System.out.println(result);
    }

    private final int mod = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {

        int[][] src = new int[m + 2][n + 2];
        src[i + 1][j + 1] = 1;

        for (int c = 0; c < N; c++) {
            int[][] dest = new int[m + 2][n + 2];
            // 复制四周的值，这些值不需要变化
            for (int d = 0; d < m + 2; d++) {
                dest[d][0] = src[d][0];
                dest[d][n + 1] = src[d][n + 1];
            }
            for (int d = 1; d < n + 1; d++) {
                dest[0][d] = src[0][d];
                dest[m + 1][d] = src[m + 1][d];
            }

            // 中间每一个值都想四个方向扩散一次
            for (int a = 1; a <= m; a++) {
                for (int b = 1; b <= n; b++) {
                    int x = src[a][b];
                    if (x != 0) {
                        x %= mod;
                        dest[a - 1][b] = (dest[a - 1][b] + x) % mod;
                        dest[a + 1][b] = (dest[a + 1][b] + x) % mod;
                        dest[a][b - 1] = (dest[a][b - 1] + x) % mod;
                        dest[a][b + 1] = (dest[a][b + 1] + x) % mod;
                    }
                }
            }

            src = dest;
        }

        //四周的值的和就是最终的结果
        int result = 0;
        for (int d = 0; d < m + 2; d++) {
            result = (result + src[d][0]) % mod;
            result = (result + src[d][n + 1]) % mod;
        }
        for (int d = 1; d < n + 1; d++) {
            result = (result + src[0][d]) % mod;
            result = (result + src[m + 1][d]) % mod;
        }

        return result % mod;
    }


}
