package com.cyanflxy.leetcode._4

fun find132pattern(nums: IntArray): Boolean {
    if (nums.size < 3) {
        return false
    }

    val min = IntArray(nums.size)
    min[0] = nums[0]
    for (i in 1 until nums.size) {
        min[i] = kotlin.math.min(min[i - 1], nums[i])
    }

    val stack = IntArray(nums.size)
    var si = 0;
    for (i in nums.size - 1 downTo 0) {
        if (nums[i] > min[i]) {
            while (si > 0 && stack[si - 1] <= min[i]) {
                si--
            }
            if (si > 0 && stack[si - 1] < nums[i]) {
                return true
            }
            stack[si++] = nums[i]
        }
    }

    return false
}