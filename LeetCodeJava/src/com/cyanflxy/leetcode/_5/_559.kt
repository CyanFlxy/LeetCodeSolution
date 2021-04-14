package com.cyanflxy.leetcode._5

import com.cyanflxy.leetcode.help.Node

var deep559 = 0

fun maxDepth(root: Node?): Int {
    dfs(root, 1)
    return deep559
}

fun dfs(root: Node?, deep: Int) {
    root?.apply {
        if (deep559 < deep) {
            deep559 = deep
        }

        children?.forEach {
            dfs(it, deep + 1)
        }
    }
}