package com.cyanflxy.leetcode._17;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _1723 {

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int len = jobs.length;

        int max = jobs[len - 1];
        int sum = Arrays.stream(jobs).sum();

        int low = max;
        int high = sum;

        while (low < high) {
            int mid = (low + high) / 2;
            if (check(jobs, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean check(int[] jobs, int k, int limit) {
        int[] load = new int[k];
        return backtrack(jobs, load, k, jobs.length - 1, limit);
    }

    private boolean backtrack(int[] jobs, int[] load, int k, int i, int limit) {
        int cur = jobs[i];
        for (int j = 0; j < k; j++) {
            if (load[j] + cur <= limit) {
                load[j] += cur;

                if (i == 0 || backtrack(jobs, load, k, i - 1, limit)) {
                    return true;
                }

                load[j] -= jobs[i];
            }

            if (load[j] == 0 || load[j] + cur == limit) {
                break;
            }

        }
        return false;
    }
}
