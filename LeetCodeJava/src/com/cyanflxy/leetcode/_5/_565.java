package com.cyanflxy.leetcode._5;

public class _565 {

    public static void main(String[] args) {
        int result = new _565().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
        System.out.println(result);
    }

    private int currentCount;
    private boolean[] visited;

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int half = (n + 1) / 2;// 如果参与的数字比一半多，就不用继续寻找了
        int max = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                currentCount = 0;
                visitNumber(nums, i);
                max = Math.max(currentCount, max);
            }

            if (max >= half) {
                break;
            }
        }

        return max;
    }

    private void visitNumber(int[] nums, int index) {
        visited[index] = true;
        currentCount++;

        if (!visited[nums[index]]) {
            visitNumber(nums, nums[index]);
        }
    }
}
