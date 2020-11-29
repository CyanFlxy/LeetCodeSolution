package com.cyanflxy.leetcode._4


fun constructRectangle(area: Int): IntArray {
    var k: Int = kotlin.math.sqrt(area.toDouble()).toInt()
    for (i in k downTo 1) {
        if (area % i == 0) {
            return intArrayOf(area / i, i)
        }
    }
    return intArrayOf(area, 1)
}