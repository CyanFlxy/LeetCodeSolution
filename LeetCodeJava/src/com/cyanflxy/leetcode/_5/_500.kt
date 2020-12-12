package com.cyanflxy.leetcode._5

fun findWords(words: Array<String>): Array<String> {
    val top = "qwertyuiop"
    val middle = "asdfghjkl"
    val bottom = "zxcvbnm"

    val resultList = ArrayList<String>()
    for (str in words) {
        if (str.isEmpty()) {
            resultList.add(str)
        } else {
            val ch = str[0]
            var inStr = when {
                top.contains(ch, true) -> top
                middle.contains(ch, true) -> middle
                else -> bottom
            }
            if (isAllCharIn(str, inStr)) {
                resultList.add(str)
            }
        }
    }

    return Array(resultList.size) { resultList[it] }
}

fun isAllCharIn(all: String, inStr: String): Boolean {
    for (ch in all) {
        if (!inStr.contains(ch, true)) {
            return false
        }
    }
    return true
}