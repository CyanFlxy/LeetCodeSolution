package com.cyanflxy.leetcode._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/9/11
 */
public class _216 {

    public static void main(String... args) {
        _216 o = new _216();
        System.out.println(o.combinationSum3(3, 15));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || n >= k * 9) {
            return result;
        }

        dfs(new int[k], 0, 1, n, result);

        return result;
    }

    private void dfs(int[] result, int index, int startNum, int remain, List<List<Integer>> list) {
        if (index == result.length - 1) {
            // 无法拆解数字了
            if (remain <= 9) {
                result[index] = remain;
                addResult(list, result);
            }
            return;
        }

        for (int i = startNum; i <= 9; i++) {
            if (remain > i * 2) {
                result[index] = i;
                dfs(result, index + 1, i + 1, remain - i, list);
            } else {
                break;
            }
        }
    }

    private void addResult(List<List<Integer>> list, int[] result) {
        List<Integer> r = new ArrayList<>();
        for (int i : result) {
            r.add(i);
        }
        list.add(r);
    }

}
