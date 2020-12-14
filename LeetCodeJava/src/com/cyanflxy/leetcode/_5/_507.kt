package com.cyanflxy.leetcode._5

fun convertToBase7(num: Int): String {
    if (num == 0) {
        return "0"
    }

    val sign = num < 0
    var v = if (num >= 0) num else -num
    val sb = StringBuilder()

    while (v > 0) {
        val i = v % 7
        sb.append(i)
        v /= 7
    }

    if (sign) {
        sb.append('-')
    }
    return sb.reverse().toString()
}