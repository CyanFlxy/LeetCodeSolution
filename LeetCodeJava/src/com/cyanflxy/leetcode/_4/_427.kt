package com.cyanflxy.leetcode._4

import com.cyanflxy.leetcode._4._427.Node


class _427 {
    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }
}

fun main() {
    construct(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)))
}

fun construct(grid: Array<IntArray>): Node? {
    return construct(grid, 0, grid.size, 0, grid.size)
}

fun construct(grid: Array<IntArray>, fromX: Int, toX: Int, fromY: Int, toY: Int): Node? {
    val v = grid[fromX][fromY]
    if (toX - fromX == 1) {
        return Node(v == 1, true)
    }

    var same = true
    for (i in fromX until toX) {
        val arr = grid[i]
        for (j in fromY until toY) {
            if (arr[j] != v) {
                same = false
                break
            }
        }
        if (!same) {
            break
        }
    }

    if (same) {
        return Node(v == 1, true)
    }

    val root = Node(false, false)
    val midX = (fromX + toX) / 2
    val midY = (fromY + toY) / 2
    root.topLeft = construct(grid, fromX, midX, fromY, midY)
    root.topRight = construct(grid, fromX, midX, midY, toY)
    root.bottomLeft = construct(grid, midX, toX, fromY, midY)
    root.bottomRight = construct(grid, midX, toX, midY, toY)

    return root
}