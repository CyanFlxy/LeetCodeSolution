package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.06.02
 */
public class _880 {
    public String decodeAtIndex(String s, int k) {
        Str str = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                int count = c - '0';
                str = new Str(str, sb.toString(), count);
                if (str.length() >= k) {
                    return str.charAt(k - 1);
                }
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            str = new Str(str, sb.toString(), 1);
        }
        return str.charAt(k - 1);
    }

    static class Str {
        Str pre;
        String s;
        int count;
        long len;

        public Str(Str pre, String s, int count) {
            this.pre = pre;
            this.s = s;
            this.count = count;
        }

        long length() {
            if (len == 0) {
                long pl = pre == null ? 0 : pre.length();
                len = (pl + s.length()) * count;
            }
            return len;
        }

        String charAt(int i) {
            int pl = pre == null ? 0 : (int) pre.length();
            i = i % (pl + s.length());
            if (i < pl) {
                return pre.charAt(i);
            } else {
                return String.valueOf(s.charAt(i - pl));
            }
        }

    }
}
