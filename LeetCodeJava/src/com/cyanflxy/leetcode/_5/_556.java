package com.cyanflxy.leetcode._5;

public class _556 {

    public static void main(String[] args) {
        int result = new _556().nextGreaterElement(12746754);
        System.out.println(result);
    }

    public int nextGreaterElement(int n) {
        int[] bits = new int[10];
        int bitCount = 0;
        int firstLower = -1;

        while (n > 0) {
            bits[bitCount] = n % 10;
            n /= 10;

            if (firstLower < 0 && bitCount > 0 && bits[bitCount] < bits[bitCount - 1]) {
                firstLower = bitCount;
            }
            bitCount++;
        }

        if (firstLower < 0) {
            return -1;
        }

        int lowBit = bits[firstLower];
        for (int i = 0; i < firstLower; i++) {
            if (bits[i] > lowBit) {
                bits[firstLower] = bits[i];
                bits[i] = lowBit;
                break;
            }
        }

        long result = 0;
        for (int i = bitCount - 1; i >= firstLower; i--) {
            result = result * 10 + bits[i];
        }
        for (int i = 0; i < firstLower; i++) {
            result = result * 10 + bits[i];
        }

        if (result > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) result;
        }
    }
}
