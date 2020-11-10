package com.cyanflxy.leetcode._4;

import java.util.ArrayList;
import java.util.List;

public class _401 {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        addResult(result, getPossibleHour(0), getPossibleMinute(num));
        addResult(result, getPossibleHour(1), getPossibleMinute(num - 1));
        addResult(result, getPossibleHour(2), getPossibleMinute(num - 2));
        addResult(result, getPossibleHour(3), getPossibleMinute(num - 3));
        return result;
    }

    private void addResult(List<String> result, String[] hour, String[] minute) {
        if (hour.length == 0 || minute.length == 0) {
            return;
        }

        for (String h : hour) {
            for (String m : minute) {
                result.add(h + ":" + m);
            }
        }
    }

    private String[] getPossibleHour(int count) {
        switch (count) {
            case 0:
                return new String[]{"0"};
            case 1:
                return new String[]{"1", "2", "4", "8",};
            case 2:
                return new String[]{"3", "5", "6", "9", "10",};
            case 3:
                return new String[]{"7", "11"};
            default:
                return new String[0];
        }
    }

    private String[] getPossibleMinute(int count) {
        // 32\16\8\4\2\1
        switch (count) {
            case 0:
                return new String[]{"00"};
            case 1:
                return new String[]{"01", "02", "04", "08", "16", "32"};
            case 2:
                return new String[]{
                        "03", "05", "06", "09", "10", "12",
                        "17", "18", "20", "24", "33", "34",
                        "36", "40", "48",
                };
            case 3:
                return new String[]{
                        "07", "11", "13", "14", "19", "21",
                        "22", "25", "26", "28", "35", "37",
                        "38", "41", "42", "44", "49", "50",
                        "52", "56",
                };
            case 4:
                return new String[]{
                        "15", "23", "27", "29", "30", "39",
                        "43", "45", "46", "51", "53", "54",
                        "57", "58",
                };
            case 5:
                return new String[]{"31", "47", "55", "59"};
            default:
                return new String[0];
        }
    }
}
