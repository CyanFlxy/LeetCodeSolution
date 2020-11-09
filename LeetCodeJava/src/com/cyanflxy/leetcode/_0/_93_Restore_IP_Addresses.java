package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <pre>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * </pre>
 * Created by cyanflxy on 2018/5/21.
 */

public class _93_Restore_IP_Addresses {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _93_Restore_IP_Addresses object = new _93_Restore_IP_Addresses();

//        System.out.println(object.restoreIpAddresses("255255111135"));
//        System.out.println(object.restoreIpAddresses("1234"));
//        System.out.println(object.restoreIpAddresses("25525511135"));
//        System.out.println(object.restoreIpAddresses("2552550135"));
//        System.out.println(object.restoreIpAddresses("010010"));
//        System.out.println(object.restoreIpAddresses("10101010"));
//        System.out.println(object.restoreIpAddresses("1111111"));
        System.out.println(object.restoreIpAddresses("123123123"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return result;
        }

        char[] bytes = s.toCharArray();
        char[] buffer = new char[bytes.length + 3];
        restoreIpAddress(result, bytes, 0, buffer, 0, 0);

        return result;
    }

    private void restoreIpAddress(List<String> result, char[] bytes, int byteIndex,
                                  char[] buffer, int bufferIndex, int dotCount) {

        if (byteIndex == bytes.length) {
            if (buffer[bufferIndex - 1] != '.') {
                result.add(new String(buffer));
            }
            return;
        }

        int remainBytes = bytes.length - byteIndex;
        int remainDot = 3 - dotCount;

        if (remainDot <= 0) {
            if (remainBytes == 1 || (remainBytes > 1 && remainBytes <= 3 && bytes[byteIndex] != '0')) {
                int remainValue = 0;
                for (int i = byteIndex; i < bytes.length; i++) {
                    remainValue = remainValue * 10 + bytes[i] - '0';
                    buffer[bufferIndex++] = bytes[i];
                }

                if (remainValue <= 255) {
                    result.add(new String(buffer));
                }
            }
            return;
        }


        if (remainBytes > (remainDot + 1) * 3) {
            return;
        }

        if (remainBytes == (remainDot + 1) * 3) {
            // 余下的都是三个一组
            for (int i = byteIndex; i < bytes.length; i += 3) {
                int a1 = bytes[i] - '0';
                if (a1 == 0) {
                    return;
                }
                int a2 = bytes[i + 1] - '0';
                int a3 = bytes[i + 2] - '0';
                if (a1 * 100 + a2 * 10 + a3 > 255) {
                    return;
                }

                buffer[bufferIndex++] = bytes[i];
                buffer[bufferIndex++] = bytes[i + 1];
                buffer[bufferIndex++] = bytes[i + 2];

                if (bufferIndex + 1 < buffer.length) {
                    buffer[bufferIndex++] = '.';
                }
            }

            result.add(new String(buffer));
            return;
        }

        if (remainBytes < remainDot + 1) {
            return;
        }
        if (remainBytes == remainDot + 1) {
            // 余下的都是一个一组
            for (int i = byteIndex; i < bytes.length - 1; i++) {
                buffer[bufferIndex++] = bytes[i];
                buffer[bufferIndex++] = '.';
            }
            buffer[bufferIndex] = bytes[bytes.length - 1];
            result.add(new String(buffer));
            return;
        }


        buffer[bufferIndex] = bytes[byteIndex];
        buffer[bufferIndex + 1] = '.';
        restoreIpAddress(result, bytes, byteIndex + 1, buffer, bufferIndex + 2, dotCount + 1);

        if (bytes[byteIndex] != '0') {
            buffer[bufferIndex + 1] = bytes[byteIndex + 1];
            buffer[bufferIndex + 2] = '.';
            restoreIpAddress(result, bytes, byteIndex + 2, buffer, bufferIndex + 3, dotCount + 1);

            int intValue = (bytes[byteIndex] - '0') * 100 + (bytes[byteIndex + 1] - '0') * 10 + bytes[byteIndex + 2] - '0';
            if (intValue <= 255) {
                buffer[bufferIndex + 2] = bytes[byteIndex + 2];
                buffer[bufferIndex + 3] = '.';
                restoreIpAddress(result, bytes, byteIndex + 3, buffer, bufferIndex + 4, dotCount + 1);
            }
        }

    }
}
