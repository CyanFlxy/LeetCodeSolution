package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/simplify-path/description/
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Created by cyanflxy on 2018/3/22.
 */

public class _71_Simplify_Path {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _71_Simplify_Path object = new _71_Simplify_Path();
        System.out.println(object.simplifyPath("/a/./b/../../c/"));
        System.out.println(object.simplifyPath("/home/"));
        System.out.println(object.simplifyPath("/../"));
        System.out.println(object.simplifyPath("/a/../"));
        System.out.println(object.simplifyPath("/a/b/"));
        System.out.println(object.simplifyPath("/a/b/c/.."));
        System.out.println(object.simplifyPath("/a//b/c/.."));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1) {
            return path;
        }
        if (path.charAt(0) != '/') {
            return "";
        }

        int start = 1;
        List<String> dirs = new ArrayList<>();

        while (start < path.length()) {
            int next = path.indexOf('/', start);
            if (next == -1) {
                next = path.length();
            }

            String sub = path.substring(start, next);
            if (sub.length() != 0 && !".".equals(sub)) {
                if ("..".equals(sub)) {
                    if (!dirs.isEmpty()) {
                        dirs.remove(dirs.size() - 1);
                    }
                } else {
                    dirs.add(sub);
                }
            }

            start = next + 1;
        }

        if (dirs.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : dirs) {
                sb.append("/").append(s);
            }
            return sb.toString();
        }
    }

}
