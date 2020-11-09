package com.cyanflxy.leetcode.random;

import java.util.ArrayList;
import java.util.List;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * <p>
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _2 {

    public String getHint(String secret, String guess) {
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        int bulls = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                bulls++;
            } else {
                list1.add(arr1[i]);
                list2.add(arr2[i]);
            }
        }

        int cows = 0;
        for (Character c : list2) {
            if (list1.contains(c)) {
                list1.remove(c);
                cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }

}
