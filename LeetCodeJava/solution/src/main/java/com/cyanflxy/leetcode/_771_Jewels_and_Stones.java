package com.cyanflxy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 * <p>
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct,
 * and all characters in J and S are letters.
 * Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <pre>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * </pre>
 * Example 1:
 * <pre>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * </pre>
 * Note:
 * <pre>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/3.
 */

public class _771_Jewels_and_Stones {

    public static void main(String... args) {
        int result = new _771_Jewels_and_Stones()
                .numJewelsInStones("aA", "aAAbbbb");
        System.out.println(result);
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        int jLength = J.length();
        int sLength = S.length();

        Set<Character> jSets = new HashSet<>();
        for (int i = 0; i < jLength; i++) {
            jSets.add(J.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < sLength; i++) {
            if (jSets.contains(S.charAt(i))) {
                result++;
            }
        }

        return result;
    }
}
