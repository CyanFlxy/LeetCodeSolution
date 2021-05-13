package com.cyanflxy.leetcode._7;

import com.cyanflxy.leetcode.help.Utils;

import java.util.*;

/**
 * @author cyanflxy
 * @since 2021.05.13
 */
public class _756 {

    public static void main(String[] args) {
//        new _756().pyramidTransition("AABA", Utils.toList("AAA", "AAB", "ABA", "ABB", "BAC"));
        boolean result = new _756().pyramidTransition("BDBBAA", Utils.toList("ACB", "ACA", "AAA", "ACD", "BCD", "BAA", "BCB", "BCC", "BAD", "BAB", "BAC", "CAB", "CCD", "CAA", "CCA", "CCC", "CAD", "DAD", "DAA", "DAC", "DCD", "DCC", "DCA", "DDD", "BDD", "ABB", "ABC", "ABD", "BDB", "BBD", "BBC", "BBA", "ADD", "ADC", "ADA", "DDC", "DDB", "DDA", "CDA", "CDD", "CBA", "CDB", "CBD", "DBA", "DBC", "DBD", "BDA"));
        System.out.println(result);
    }

    private static final int[] prime = {1, 2, 4, 8, 16, 32, 64};
    private final Map<Integer, List<Integer>> allowedMap = new HashMap<>();

    private int asKey(int a, int b) {
        return (a << 8) | b;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String allow : allowed) {
            int a = prime[allow.charAt(0) - 'A'];
            int b = prime[allow.charAt(1) - 'A'];
            int c = prime[allow.charAt(2) - 'A'];
            int btm = asKey(a, b);
            List<Integer> list = allowedMap.computeIfAbsent(btm, integer -> new ArrayList<>());
            list.add(c);
        }

        List<Set<Integer>> bottomPrime = new ArrayList<>();
        for (int i = 0; i < bottom.length(); i++) {
            Set<Integer> list = new HashSet<>();
            list.add(prime[bottom.charAt(i) - 'A']);
            bottomPrime.add(list);
        }

        return canBeBottom(bottomPrime);
    }

    private boolean canBeBottom(List<Set<Integer>> bottom) {
        if (bottom.size() == 1) {
            return true;
        }

        List<Set<Integer>> top = new ArrayList<>();
        for (int i = 0; i < bottom.size() - 1; i++) {
            Set<Integer> al = bottom.get(i);
            Set<Integer> bl = bottom.get(i + 1);

            Set<Integer> cl = new HashSet<>();
            for (int a : al) {
                for (int b : bl) {
                    List<Integer> list = allowedMap.get(asKey(a, b));
                    if (list != null) {
                        cl.addAll(list);
                    }
                }
            }

            if (cl.isEmpty()) {
                return false;
            }
            top.add(cl);
        }
        return canBeBottom(top);
    }
}
