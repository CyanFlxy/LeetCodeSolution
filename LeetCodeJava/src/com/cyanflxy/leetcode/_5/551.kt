package com.cyanflxy.leetcode._5

fun checkRecord(s: String): Boolean {
    var a = 0
    var l = 0

    s.onEach {
        if (it == 'A') {
            a++
            l = 0
            if (a >= 2) {
                return false
            }
        } else if (it == 'L') {
            l++
            if (l >= 3) {
                return false
            }
        } else {
            l = 0
        }
    }

    return true
}