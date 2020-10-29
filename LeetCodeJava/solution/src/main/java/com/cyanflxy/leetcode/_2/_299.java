package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/10/29
 */
public class _299 {

    public String getHint(String secret, String guess) {
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        int[] val1 = new int[10];
        int[] val2 = new int[10];

        int a = 0;
        int b = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                a++;
            } else {
                val1[arr1[i] - '0']++;
                val2[arr2[i] - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            b += Math.min(val1[i], val2[i]);
        }


        return new StringBuilder().append(a).append('A').append(b).append('B').toString();
    }

}
