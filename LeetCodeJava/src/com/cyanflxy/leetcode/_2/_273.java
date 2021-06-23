package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.06.23
 */
public class _273 {
    static final String[] nums = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",};
    static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",};
    static final String[] thousands = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int thouIndex = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int sm = num % 1000;
            num /= 1000;
            StringBuilder sub = smallNumberToWords(sm);
            if (sub != null) {
                if (result.length() > 0) {
                    result.insert(0, " ");
                }
                result.insert(0, thousands[thouIndex]);
                result.insert(0, sub);
            }
            thouIndex++;
        }
        return result.toString();
    }

    private StringBuilder smallNumberToWords(int num) {
        if (num == 0) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int h = num / 100;
        if (h > 0) {
            result.append(nums[h]).append(" Hundred");
            num %= 100;
            if (num > 0) {
                result.append(" ");
            }
        }

        if (num < nums.length) {
            result.append(nums[num]);
        } else {
            result.append(tens[num / 10]);
            if (num % 10 != 0) {
                result.append(" ").append(nums[num % 10]);
            }
        }

        return result;
    }
}
