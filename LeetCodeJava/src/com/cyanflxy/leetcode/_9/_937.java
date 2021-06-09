package com.cyanflxy.leetcode._9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.06.09
 */
public class _937 {

    private Map<String, StringObj> map = new HashMap<>();

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (o1, o2) -> {
            StringObj so1 = getObj(o1);
            StringObj so2 = getObj(o2);
            if (so1.isDigit) {
                if (so2.isDigit) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (so2.isDigit) {
                    return -1;
                } else {
                    if (so1.suffix.equals(so2.suffix)) {
                        return so1.id.compareTo(so2.id);
                    } else {
                        return so1.suffix.compareTo(so2.suffix);
                    }
                }
            }
        });

        return logs;
    }

    private StringObj getObj(String str) {
        return map.computeIfAbsent(str, s -> {
            int blank = s.indexOf(' ');
            String id = s.substring(0, blank);
            char ch = s.charAt(blank + 1);
            if (ch >= '0' && ch <= '9') {
                return new StringObj(id, null, true);
            } else {
                return new StringObj(id, s.substring(blank + 1), false);
            }
        });
    }

    static class StringObj {
        String id;
        String suffix;
        boolean isDigit;

        public StringObj(String id, String suffix, boolean isDigit) {
            this.id = id;
            this.suffix = suffix;
            this.isDigit = isDigit;
        }
    }
}
