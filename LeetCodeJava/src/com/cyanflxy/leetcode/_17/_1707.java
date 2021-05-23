package com.cyanflxy.leetcode._17;

import com.cyanflxy.leetcode.help.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cyanflxy
 * @since 2021.05.23
 */
public class _1707 {

    public static void main(String[] args) {
//        [5,2,4,6,6,3]
//[[12,4],[8,1],[6,3]]
        int[] result = new _1707().maximizeXor(Utils.toArray(5, 2, 4, 6, 6, 3), new int[][]{{6, 3}});
        System.out.println(result[0]);
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int[][] qs = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            qs[i][0] = queries[i][0];
            qs[i][1] = queries[i][1];
            qs[i][2] = i;
        }

        Arrays.sort(qs, Comparator.comparingInt(o -> o[1]));

        int[] result = new int[queries.length];
        Trie trie = new Trie();
        int index = 0;

        for (int[] query : qs) {
            int x = query[0];
            int m = query[1];

            while (index < nums.length && nums[index] <= m) {
                trie.add(nums[index]);
                index++;
            }

            if (index == 0) {
                result[query[2]] = -1;
            } else {
                result[query[2]] = trie.maxXor(x);
            }
        }

        return result;
    }

    static class Trie {
        Trie[] next = new Trie[2];

        void add(int i) {
            int b = 1 << 30;
            Trie last = this;
            while (b > 0) {
                int x = (i & b) == 0 ? 0 : 1;
                if (last.next[x] == null) {
                    last.next[x] = new Trie();
                }
                last = last.next[x];
                b >>= 1;
            }
        }

        int maxXor(int x) {
            int b = 1 << 30;
            Trie last = this;
            while (b > 0) {
                int i = (x & b) == 0 ? 1 : 0;
                if (last.next[i] != null) {
                    last = last.next[i];
                    x |= b;
                } else {
                    last = last.next[1 - i];
                    if (i == 0) {
                        x -= b;
                    }
                }
                b >>= 1;
            }
            return x;
        }
    }
}
