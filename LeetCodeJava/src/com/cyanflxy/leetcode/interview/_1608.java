package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.06.23
 */
public class _1608 {
    static final String[] nums = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",};
    static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",};
    static final String[] thousands = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int thouIndex = 0;
        String result = "";
        while (num > 0) {
            int sm = num % 1000;
            num /= 1000;
            String sub = smallNumberToWords(sm);
            if (sub != null) {
                result = sub + thousands[thouIndex] + (result.length() > 0 ? " " : "") + result;
            }
            thouIndex++;
        }
        return result;
    }

    private String smallNumberToWords(int num) {
        if (num == 0) {
            return null;
        }

        String result = "";
        int h = num / 100;
        if (h > 0) {
            result = nums[h] + " Hundred";
            num %= 100;
            if (num > 0) {
                result += " ";
            }
        }

        if (num < nums.length) {
            result += nums[num];
        } else {
            result += tens[num / 10];
            if (num % 10 != 0) {
                result += " " + nums[num % 10];
            }
        }

        return result;
    }
}
