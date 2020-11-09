package com.cyanflxy.leetcode._1;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cyanflxy
 * @since 2019/6/15
 */
public class _120_triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> last = triangle.get(i - 1);
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                int v1 = j > 0 ? last.get(j - 1) : Integer.MAX_VALUE;
                int v2 = j <= last.size() - 1 ? last.get(j) : Integer.MAX_VALUE;
                current.set(j, current.get(j) + Math.min(v1, v2));
            }
        }

        int minValue = Integer.MAX_VALUE;

        List<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            minValue = Math.min(minValue, last.get(i));
        }

        return minValue;
    }

}
