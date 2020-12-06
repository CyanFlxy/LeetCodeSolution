package com.cyanflxy.leetcode._4

import java.util.*
import kotlin.collections.ArrayList


class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}


fun levelOrder(root: Node?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    if (root == null) {
        return result
    }
    val seprate = Node(0)
    val list = LinkedList<Node>()
    root?.apply { list.add(root) }
    list.add(seprate)

    var cur = ArrayList<Int>()
    result.add(cur)
    while (list.isNotEmpty()) {
        val n = list.removeFirst()
        if (n == seprate) {
            if (list.isNotEmpty()) {
                list.add(seprate)
                cur = ArrayList()
                result.add(cur)
            }
        } else {
            cur.add(n.`val`)
            n.children.forEach {
                it?.apply { list.add(it) }
            }
        }
    }

    return result
}
