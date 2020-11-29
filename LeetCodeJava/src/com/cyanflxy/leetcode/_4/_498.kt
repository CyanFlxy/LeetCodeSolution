package com.cyanflxy.leetcode._4

import kotlin.math.max
import kotlin.math.min

fun main() {
    var matrix = arrayOf(intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9))
    matrix = arrayOf(intArrayOf(2, 3))
    matrix = arrayOf(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(6, 7))
    matrix = arrayOf(intArrayOf(2, 3, 4), intArrayOf(5, 6, 7))
    var result = findDiagonalOrder(matrix)
    println(result.contentToString())
}

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return intArrayOf()
    }

    var m = matrix.size
    var n = matrix[0].size
    var result = IntArray(m * n)
    var index = 0
    var reverse = false

    for (i in 0 until m) {
        if (reverse) {
            for (j in min(i, n - 1) downTo 0) {
                result[index++] = matrix[i - j][j]
            }
        } else {
            for (j in 0..min(i, n - 1)) {
                result[index++] = matrix[i - j][j]
            }
        }
        reverse = !reverse
    }

    for (i in 1 until n) {
        var total = i + m - 1
        if (reverse) {
            for (j in max(0, total - n + 1) until m) {
                result[index++] = matrix[j][total - j]
            }
        } else {
            for (j in m - 1 downTo max(0, total - n + 1)) {
                result[index++] = matrix[j][total - j]
            }
        }
        reverse = !reverse
    }

    return result
}