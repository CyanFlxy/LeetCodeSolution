package com.cyanflxy.leetcode._4

fun licenseKeyFormatting(S: String, K: Int): String {
    var sb = StringBuilder()
    var count = 0
    for (ch in S.toCharArray().reversed()) {
        if (ch != '-') {
            sb.append(ch.toUpperCase())
            count++;
        }
        if (count == K) {
            sb.append('-')
            count = 0
        }
    }

    if (sb.endsWith('-')) {
        sb.deleteCharAt(sb.length - 1)
    }

    return sb.reverse().toString()
}