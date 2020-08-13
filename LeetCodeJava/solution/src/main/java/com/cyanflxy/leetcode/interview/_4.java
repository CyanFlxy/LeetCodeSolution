package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * meican -1
 *
 * @author cyanflxy
 * @since 2020/8/13
 */
public class _4 {


    public boolean isBST(TreeNode node) {
        // write your code here
        if (node == null) {
            return true;
        }
        return checkBst(node, null, null);
    }

    public boolean checkBst(TreeNode node, Integer min, Integer max) {

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        boolean result = true;
        if (node.left != null) {
            result = result && checkBst(node.left, min, node.val);
        }

        if (node.right != null) {
            result = result && checkBst(node.right, node.val, max);
        }
        return result;
    }

    public boolean checkDuplicate(String[] input) {
        // write your code here
        Set<String> set = new HashSet<>();
        for (String str : input) {
            if (set.contains(str)) {
                return true;
            }
            set.add(str);
        }
        return false;
    }

    public static void main(String... args) {
        int result = new _4().reverse(0x80000000);
        System.out.println(Integer.toHexString(result));
    }

    public int reverse(int input) {
        int result = 0;
        int bit = 1;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((input & bit) == 1) {
                result |= 1;
            }
            input >>= 1;
        }

        return result;
    }
}
