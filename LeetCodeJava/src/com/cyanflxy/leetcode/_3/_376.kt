package com.cyanflxy.leetcode._3

fun wiggleMaxLength(nums: IntArray): Int {
    if (nums.size < 2) {
        return nums.size
    }

    var result = nums.size
    var startIndex = 1
    while (startIndex < nums.size && nums[startIndex] - nums[startIndex - 1] == 0) {
        startIndex++
        result--
    }
    if (startIndex >= nums.size) {
        return result
    }

    var lastDiff = nums[startIndex] - nums[startIndex - 1]

    for (i in startIndex + 1 until nums.size) {
        val diff = nums[i] - nums[i - 1]
        if (diff * lastDiff >= 0) {
            result--
        }
        if (diff != 0) {
            lastDiff = diff
        }
    }

    return result
}