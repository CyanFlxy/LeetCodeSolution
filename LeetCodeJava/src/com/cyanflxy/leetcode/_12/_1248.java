package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/7
 */
public class _1248 {

    public static void main(String... args) {
        int result = new _1248().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
        System.out.println(result);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int oddCount = 0;
        int start = 0;
        int end = 0;
        int count = 0;

        while (true) {
            int leftEven = 1;
            while (start < len && (nums[start] & 1) == 0) {
                leftEven++;
                start++;
            }

            while (oddCount < k && end < len) {
                if ((nums[end] & 1) == 1) {
                    oddCount++;
                }
                end++;
            }

            if (oddCount != k) {
                break;
            }

            int rightEvent = 1;
            while (end < len) {
                if ((nums[end] & 1) == 0) {
                    rightEvent++;
                    end++;
                } else {
                    break;
                }
            }

            count += (leftEven * rightEvent);

            start++;
            oddCount--;
        }

        return count;
    }

}
