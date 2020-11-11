package com.cyanflxy.leetcode._5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _514 {

    public static void main(String[] args) {
        int result;
//        result = new _514().findRotateSteps("abcde", "ade");
        result = new _514().findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx");
        System.out.println(result);
    }

    //
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/freedom-trail/solution/zi-you-zhi-lu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

//  这个方法只有在ring中字母唯一时绝对正确，有多个相同字母时，无法确定最佳路径
//    public int findRotateSteps(String ring, String key) {
//        int len = ring.length();
//        Map<Character, List<Integer>> ringMap = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            char ch = ring.charAt(i);
//            if (ringMap.containsKey(ch)) {
//                ringMap.get(ch).add(i);
//            } else {
//                List<Integer> index = new ArrayList<>();
//                index.add(i);
//                ringMap.put(ch, index);
//            }
//        }
//
//        int rotate = 0;
//        int result = 0;
//
//        for (char ch : key.toCharArray()) {
//            List<Integer> index = ringMap.get(ch);
//            int minStep = Integer.MAX_VALUE;
//            boolean back = false;
//            for (Integer i : index) {
//                int min1 = (i + len - rotate) % len;
//                int min2 = len - min1;
//
//                if (minStep > min1 || minStep > min2) {
//                    if (min1 < min2) {
//                        minStep = min1;
//                        back = false;
//                    } else {
//                        minStep = min2;
//                        back = true;
//                    }
//                }
//            }
//
//            result += minStep;
//            if (back) {
//                rotate += len - minStep;
//            } else {
//                rotate += minStep;
//            }
//            rotate = rotate % len;
//        }
//
//        return result + key.length();
//    }
}
