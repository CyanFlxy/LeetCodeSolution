package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/10/21
 */
public class _925 {

    public static void main(String... args) {
        new _925().isLongPressedName("alex", "aaleex");
    }

    public boolean isLongPressedName(String name, String typed) {
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        int nameLen = name.length();
        int typedLen = typed.length();

        int typedIndex = 0;

        for (int i = 0; i < nameLen; ) {
            char ch = nameChar[i];
            int sameCount = 1;
            while (i < nameLen - 1 && nameChar[i + 1] == ch) {
                i++;
                sameCount++;
            }

            while (sameCount > 0) {
                if (typedIndex < typedLen && typedChar[typedIndex] == ch) {
                    typedIndex++;
                    sameCount--;
                } else {
                    return false;
                }
            }

            while (typedIndex < typedLen && typedChar[typedIndex] == ch) {
                typedIndex++;
            }

            i++;
        }

        return typedIndex == typedLen;
    }
}
