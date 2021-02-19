package com.cyanflxy.leetcode._5

fun optimalDivision(nums: IntArray): String {
    if (nums.size == 1) {
        return nums[0].toString()
    } else if (nums.size == 2) {
        return nums[0].toString() + '/' + nums[1].toString()
    } else {
        val sb = StringBuilder()
        sb.append(nums[0]).append("/(")
        for (i in 1 until nums.size) {
            sb.append(nums[i]).append('/')
        }
        sb.deleteCharAt(sb.length - 1)
        sb.append(')')
        return sb.toString()
    }
}