package com.cyanflxy.leetcode._0;

/**
 * @author cyanflxy
 * @since 2021.06.17
 */
public class _65 {

    public static void main(String[] args) {
//        System.out.println(new _65().isNumber("0"));
//        System.out.println(new _65().isNumber(".1"));
//        System.out.println(new _65().isNumber("."));
        System.out.println(new _65().isNumber("-.3e6"));
    }

    int index;

    public boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        index = 0;

        if (arr[index] == '+' || arr[0] == '-') {
            index++;
            if (index >= arr.length) {
                return false;
            }
        }

        if (readFloat(arr)) {
            if (index == arr.length) {
                return true;
            }
        } else {
            return false;
        }


        if ((arr[index] == 'e' || arr[index] == 'E')) {
            index++;
            if (index == arr.length) {
                return false;
            }
            if (arr[index] == '+' || arr[index] == '-') {
                index++;
            }
            return index < arr.length && readInteger(arr);
        }

        return false;
    }

    private boolean readFloat(char[] arr) {
        boolean havePoint = false;
        boolean haveNum = false;

        while (index < arr.length) {
            char c = arr[index];
            if (c == '.') {
                if (havePoint) {
                    return false;
                }
                havePoint = true;
            } else if (c == 'e' || c == 'E') {
                return haveNum;
            } else if (c < '0' || c > '9') {
                return false;
            } else {
                haveNum = true;
            }
            index++;
        }
        return haveNum;
    }

    private boolean readInteger(char[] arr) {
        while (index < arr.length) {
            char c = arr[index];
            if (c < '0' || c > '9') {
                return false;
            }
            index++;
        }
        return true;
    }

}
