package com.cyanflxy.leetcode._6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] split = path.split(" ");
            String dir = split[0] + "/";
            for (int i = 1; i < split.length; i++) {
                String file = split[i];
                int first = file.indexOf('(');
                String name = file.substring(0, first);
                String content = file.substring(first);
                map.computeIfAbsent(content, s -> new ArrayList<>()).add(dir + name);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }
        return result;
    }
}
