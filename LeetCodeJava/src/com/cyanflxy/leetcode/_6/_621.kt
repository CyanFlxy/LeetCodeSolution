package com.cyanflxy.leetcode._6

fun main() {
    val result = leastInterval(charArrayOf('A', 'B'), 3)
    println(result)
}

fun leastInterval(tasks: CharArray, n: Int): Int {
    if (n == 0) {
        return tasks.size
    }
    val count = IntArray(26)

    for (ch in tasks) {
        count[ch - 'A']++
    }

    var max = 0
    var maxCount = 0

    count.forEach {
        if (it > max) {
            max = it
            maxCount = 1
        } else if (it == max) {
            maxCount++
        }
    }

    return kotlin.math.max((max - 1) * (n + 1) + maxCount, tasks.size)
}