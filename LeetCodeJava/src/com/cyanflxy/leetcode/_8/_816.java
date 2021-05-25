package com.cyanflxy.leetcode._8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.26
 */
public class _816 {

    public static void main(String[] args) {
        new _816().ambiguousCoordinates("(100)");
    }

    public List<String> ambiguousCoordinates(String s) {
        int len = s.length();
        String num = s.substring(1, len - 1);
        List<String> result = new ArrayList<>();

        for (int i = 1; i < num.length(); i++) {
            String num1 = num.substring(0, i);
            String num2 = num.substring(i);

            List<String> num1List = getPointed(num1);
            List<String> num2List = getPointed(num2);

            if (num1List.size() > 0 && num2List.size() > 0) {
                for (String n1 : num1List) {
                    for (String n2 : num2List) {
                        result.add("(" + n1 + ", " + n2 + ")");
                    }
                }
            }

        }

        return result;

    }

    private List<String> getPointed(String num) {
        List<String> result = new ArrayList<>();
        int len = num.length();
        char first = num.charAt(0);

        if (len > 1 && num.charAt(num.length() - 1) != '0') {
            result.add(first + "." + num.substring(1));

            if (first != '0' && len > 2) {
                for (int i = 2; i < len; i++) {
                    result.add(num.substring(0, i) + "." + num.substring(i));
                }
            }

        }

        if (len == 1 || first != '0') {
            result.add(num);
        }

        return result;
    }

}
