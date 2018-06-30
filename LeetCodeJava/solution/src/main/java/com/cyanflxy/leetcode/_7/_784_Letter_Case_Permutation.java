package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-72/problems/letter-case-permutation/
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * <pre>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * </pre>
 * Note:
 * <p>
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 * <p>
 * Created by cyanflxy on 2018/2/26.
 */

public class _784_Letter_Case_Permutation {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _784_Letter_Case_Permutation object = new _784_Letter_Case_Permutation();

        System.out.println(object.letterCasePermutation("d3f9"));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> lists = new ArrayList<>();

        if (S == null) {
            return lists;
        }

        if (S.length() == 0) {
            lists.add("");
            return lists;
        }

        char[] chars = S.toCharArray();
        char[] results = new char[chars.length];

        charsCasePermutation(lists, chars, results, 0);

        return lists;
    }

    private void charsCasePermutation(List<String> result, char[] sourceChars, char[] resultChars, int currentIndex) {
        if (currentIndex >= sourceChars.length) {
            result.add(new String(resultChars));
            return;
        }

        char cc = sourceChars[currentIndex];

        if (cc >= 'a' && cc <= 'z') {
            cc -= 32;
        }

        if (cc >= 'A' && cc <= 'Z') {

            resultChars[currentIndex] = (char) (cc + 32);
            charsCasePermutation(result, sourceChars, resultChars, currentIndex + 1);

            resultChars[currentIndex] = cc;
            charsCasePermutation(result, sourceChars, resultChars, currentIndex + 1);

        } else {
            resultChars[currentIndex] = cc;
            charsCasePermutation(result, sourceChars, resultChars, currentIndex + 1);
        }
    }
}
