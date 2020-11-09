package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/11/1
 */
public class _264 {

    public static void main(String... args) {
        int i = new _264().nthUglyNumber(20);
        System.out.println(i);
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n + 2];
        ugly[1] = 1;

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        int index = 1;
        int nv = 0;

        while (index <= n) {
            int val = ugly[index];
            int n2 = ugly[i2] * 2;
            int n3 = ugly[i3] * 3;
            int n5 = ugly[i5] * 5;

            if (n2 > val && n2 <= n3 && n2 <= n5) {
                nv = n2;
            } else if (n3 > val && n3 <= n2 && n3 <= n5) {
                nv = n3;
            } else if (n5 > val && n5 <= n2 && n5 <= n3) {
                nv = n5;
            }
            index++;
            ugly[index] = nv;

            if (n2 <= nv) {
                i2++;
            }
            if (n3 <= nv) {
                i3++;
            }
            if (n5 <= nv) {
                i5++;
            }
        }

        return ugly[n];
    }
}
