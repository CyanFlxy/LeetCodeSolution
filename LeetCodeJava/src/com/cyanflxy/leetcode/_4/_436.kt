package com.cyanflxy.leetcode._4

fun main() {
    findRightInterval(arrayOf(intArrayOf(4, 5), intArrayOf(2, 3), intArrayOf(1, 2)))
}

fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val indexes = Array(intervals.size) { IntArray(2) }
    val max = IntArray(intervals.size)

    intervals.forEachIndexed { i: Int, v: IntArray ->
        indexes[i][0] = v[0]
        indexes[i][1] = i
        max[i] = v[v.size - 1]
    }

    val c = Comparator<IntArray> { o1, o2 -> o1[0] - o2[0] }
    indexes.sortWith(c)

    val result = IntArray(max.size)

    max.forEachIndexed { i: Int, v: Int ->
        var index = indexes.binarySearch(intArrayOf(v, 0), c)
        index = if (index < 0) (-index - 1) else index
        if (index >= intervals.size) {
            result[i] = -1
        } else {
            result[i] = indexes[index][1]
        }
    }

    return result
}