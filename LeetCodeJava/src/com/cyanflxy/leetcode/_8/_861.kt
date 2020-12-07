package com.cyanflxy.leetcode._8

fun matrixScore(A: Array<IntArray>): Int {
    for (a in A) {
        if (a[0] == 1) {
            continue
        }
        for (i in a.indices) {
            a[i] = 1 - a[i]
        }
    }
    val row = A.size
    for (i in A[0].indices) {
        var ones = 0
        for (a in A) {
            if (a[i] == 1) {
                ones++
            }
        }
        if (ones * 2 < row) {
            for (j in 0 until row) {
                A[j][i] = 1 - A[j][i]
            }
        }
    }
    var result = 0
    for (a in A) {
        var v = 0
        for (i in a.indices) {
            v = v * 2 + a[i]
        }
        result += v
    }
    return result
}
