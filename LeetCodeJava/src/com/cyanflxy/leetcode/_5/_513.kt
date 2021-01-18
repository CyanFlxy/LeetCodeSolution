package com.cyanflxy.leetcode._5

import com.cyanflxy.leetcode.help.TreeNode

var value = 0
var deep = 0

fun findBottomLeftValue(root: TreeNode?): Int {
    value = root?.`val` ?: 0
    dfs(root, 0)
    return value
}

fun dfs(root: TreeNode?, d: Int) {
    if (root == null) {
        return
    }

    if (d > deep) {
        deep = d
        value = root.`val`
    }

    dfs(root.left, d + 1)
    dfs(root.right, d + 1)
}
