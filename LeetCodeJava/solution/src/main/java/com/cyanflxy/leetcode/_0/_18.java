package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/11/3
 */
public class _18 {

    public static void main(String... args) {
//        new _18().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
//        new _18().fourSum(new int[]{-5, -5, -3, -1, 0, 2, 4, 5,}, -7);
        new _18().fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 4) {
            return result;
        }


        Arrays.sort(nums);

        for (int i = 0; i <= len - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }


            for (int j = i + 1; j <= len - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }


                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }


                for (int k = j + 1; k <= len - 2; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    int remain = target - nums[i] - nums[j] - nums[k];
                    if (Arrays.binarySearch(nums, k + 1, len, remain) > 0) {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[k]);
                        answer.add(remain);
                        result.add(answer);
                    }

                }
            }
        }


        return result;

    }


}
