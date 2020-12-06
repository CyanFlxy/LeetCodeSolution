package com.cyanflxy.leetcode._4

fun main() {
//    findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    val result = findDuplicates(intArrayOf(10, 2, 5, 10, 9, 1, 1, 4, 3, 7))
    println(result)
}

fun findDuplicates(nums: IntArray): List<Int> {
    val result = ArrayList<Int>()

    for (i in nums.indices) {
        var cv = nums[i]
        nums[i] = -1
        while (cv >= 1 && cv - 1 != i) {
            val v = nums[cv - 1]
            if (v < 0) {
                nums[cv - 1] = cv
                break
            } else if (v == cv) {
                result.add(v)
                break
            } else {
                nums[cv - 1] = cv
                cv = v
            }
        }
        if (cv - 1 == i) {
            nums[i] = cv
        }
    }

    return result
}