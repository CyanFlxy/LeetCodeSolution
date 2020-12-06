package com.cyanflxy.leetcode._4

fun main() {
//    compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'))
    compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'))
}

fun compress(chars: CharArray): Int {
    if (chars.size <= 1) {
        return chars.size
    }

    var len = 0
    var curCh = chars[0]
    var curCount = 1

    for (i in 1 until chars.size) {
        if (curCh == chars[i]) {
            curCount++
        } else {
            chars[len++] = curCh
            len = writeCharCount(chars, len, curCount)

            curCh = chars[i]
            curCount = 1
        }
    }

    chars[len++] = curCh
    len = writeCharCount(chars, len, curCount)

    return len
}

fun writeCharCount(chars: CharArray, index: Int, count: Int): Int {
    if (count == 1) {
        return index
    }

    var i = index
    var c = count

    if (c >= 1000) {
        chars[i++] = '0' + (c / 1000)
        c %= 1000
    }

    if (c >= 100) {
        chars[i++] = '0' + (c / 100)
        c %= 100
    }

    if (c >= 10) {
        chars[i++] = '0' + (c / 10)
        c %= 10
    }

    chars[i++] = '0' + c
    return i
}