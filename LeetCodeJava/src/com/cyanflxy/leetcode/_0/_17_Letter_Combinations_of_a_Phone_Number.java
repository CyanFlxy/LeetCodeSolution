package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <pre>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * <p>
 * Created by cyanflxy on 2018/2/22.
 */

public class _17_Letter_Combinations_of_a_Phone_Number {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _17_Letter_Combinations_of_a_Phone_Number object = new _17_Letter_Combinations_of_a_Phone_Number();

        System.out.println(object.letterCombinations("234"));
    }

    private String[][] letters = new String[][]{
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String[]> letterArray = new ArrayList<>();
        for (char ch : digits.toCharArray()) {
            if (ch < '2' || ch > '9') {
                return Collections.emptyList();
            }
            letterArray.add(letters[ch - '2']);
        }


        return combineToString(letterArray);
    }

    private List<String> combineToString(List<String[]> letterChars) {
        if (letterChars.size() == 1) {
            List<String> result = new ArrayList<>();
            for (String ch : letterChars.get(0)) {
                result.add(ch);
            }
            return result;
        }

        List<String> subResult = combineToString(letterChars.subList(1, letterChars.size()));
        List<String> result = new ArrayList<>();

        for (String ch : letterChars.get(0)) {
            for (String sub : subResult) {
                result.add(ch + sub);
            }
        }

        return result;
    }
}
