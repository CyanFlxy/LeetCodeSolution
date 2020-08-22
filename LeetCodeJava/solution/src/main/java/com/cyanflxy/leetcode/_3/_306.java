package com.cyanflxy.leetcode._3;

import java.math.BigInteger;

/**
 * @author cyanflxy
 * @since 2020/8/22
 */
public class _306 {

    public static void main(String... args) {
        boolean result = new _306().isAdditiveNumber("121474836472147483648");
        System.out.println(result);
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        int maxLen = (num.length() - 1) / 2;

        for (int i = 1; i <= maxLen; i++) {
            for (int j = 1; j <= maxLen; j++) {
                if (checkNumber2(num, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkNumber(String num, int firstCount, int secondCount) {
        if (num.charAt(0) == '0' && firstCount > 1) {
            return false;
        }
        if (num.charAt(firstCount) == '0' && secondCount > 1) {
            return false;
        }

        if (firstCount >= 9 || secondCount >= 9) {
            return checkNumber2(num, firstCount, secondCount);
        }

        int n1 = Integer.valueOf(num.substring(0, firstCount));
        int n2 = Integer.valueOf(num.substring(firstCount, firstCount + secondCount));

        int next = firstCount + secondCount;

        while (next < num.length()) {
            int temp = n1 + n2;
            String tempStr = String.valueOf(temp);
            if (num.startsWith(tempStr, next)) {
                next += tempStr.length();
                n1 = n2;
                n2 = temp;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean checkNumber2(String num, int firstCount, int secondCount) {
        if (num.charAt(0) == '0' && firstCount > 1) {
            return false;
        }
        if (num.charAt(firstCount) == '0' && secondCount > 1) {
            return false;
        }

        BigInteger n1 = new BigInteger(num.substring(0, firstCount));
        BigInteger n2 = new BigInteger(num.substring(firstCount, firstCount + secondCount));
        int next = firstCount + secondCount;

        while (next < num.length()) {
            BigInteger temp = n1.add(n2);
            String tempStr = temp.toString();
            if (num.startsWith(tempStr, next)) {
                next += tempStr.length();
                n1 = n2;
                n2 = temp;
            } else {
                return false;
            }
        }

        return true;
    }

}
