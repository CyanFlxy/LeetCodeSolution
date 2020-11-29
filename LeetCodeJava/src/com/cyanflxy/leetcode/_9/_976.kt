package com.cyanflxy.leetcode._9

fun largestPerimeter(A: IntArray): Int {
    A.sort()

    for (i in A.size - 3 downTo 0) {
        if (A[i] + A[i + 1] > A[i + 2]) {
            return A[i] + A[i + 1] + A[i + 2]
        }
    }
    return 0
}