package com.cyanflxy.leetcode.help;

/**
 * 测试方法运行时间
 *
 * @author cyanflxy
 * @since 2018/9/6
 */
public class TimeMeasure {

    public static void measure(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        System.out.println("Runnable " + runnable + ",run time " + (end - start));
    }

}
