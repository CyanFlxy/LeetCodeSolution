package com.cyanflxy.leetcode._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _228 {

    public static void main(String... args) {
        int[] arr = {0, 1, 2, 4, 5, 7};
//        int[] arr = {0, 2, 3, 4, 6, 8, 9};
        List<String> result = new _228().summaryRanges(arr);
        System.out.println(result);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int len = nums.length - 1;
        for (int i = 0; i <= len; ) {
            String start = "" + nums[i];
            int end = findEndIndex(nums, i + 1, len, nums[i] - i);
            if (end == i) {
                result.add(start);
            } else {
                result.add(start + "->" + nums[end]);
            }
            i = end + 1;
        }

        return result;
    }

    private int findEndIndex(int[] nums, int start, int end, int offset) {
        if (start > end || nums[start] - offset != start) {
            return start - 1;
        }

        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (nums[mid] - offset == mid) {
            return findEndIndex(nums, mid + 1, end, offset);
        } else {
            return findEndIndex(nums, start + 1, mid - 1, offset);
        }
    }

    private int findEndIndex2(int[] nums, int start, int offset) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] - offset != i) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}
