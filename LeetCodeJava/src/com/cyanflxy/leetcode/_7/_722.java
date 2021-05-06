package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _722 {

    public static void main(String[] args) {
        _722 obj = new _722();
        List<String> result;

//        result = obj.removeComments(new String[]{
//                "/*Test program */",
//                "int main()",
//                "{ ",
//                "  // variable declaration ",
//                "int a, b, c;",
//                "/* This is a test",
//                "   multiline  ",
//                "   comment for ",
//                "   testing */",
//                "a = b + c;",
//                "}"
//        });
//        System.out.println(result);

        result = obj.removeComments(new String[]{
                "a/*/b//*c",
                "blank",
                "d*//e*//f"
        });
        System.out.println(result);

        result = obj.removeComments(new String[]{
                "a/*/b//*c",
                "blank",
                "d/*/e*//f"
        });
        System.out.println(result);

        result = obj.removeComments(new String[]{
                "class test{",
                "public: ",
                "   int x = 1;",
                "   /*double y = 1;*/",
                "   char c;",
                "};"
        });
        System.out.println(result);

    }

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean isInBlock = false;
        String blockStartString = "";

        String current = null;
        for (int i = 0; i <= source.length; ) {
            if (current == null || current.length() == 0) {
                if (i == source.length) {
                    break;
                }
                current = source[i];
                i++;
            }

            if (isInBlock) {
                int blockEnd = current.indexOf("*/");
                if (blockEnd >= 0) {
                    current = current.substring(blockEnd + 2);
                    isInBlock = false;
                    if (current.length() == 0) {
                        if (blockStartString.length() > 0) {
                            result.add(blockStartString);
                            blockStartString = "";
                        }
                    }
                } else {
                    current = null;
                }
                continue;
            }

            int singleStart = current.indexOf("//");
            int blockStart = current.indexOf("/*");
            if (singleStart < 0 && blockStart < 0) {
                result.add(blockStartString + current);
                blockStartString = "";
                current = null;
            } else if (blockStart < 0 || singleStart >= 0 && singleStart < blockStart) {
                if (singleStart > 0) {
                    result.add(blockStartString + current.substring(0, singleStart));
                } else if (blockStartString.length() > 0) {
                    result.add(blockStartString);
                }
                blockStartString = "";
                current = null;
            } else {
                blockStartString = blockStartString + current.substring(0, blockStart);
                isInBlock = true;
                current = current.substring(blockStart + 2);
            }
        }

        return result;
    }
}
