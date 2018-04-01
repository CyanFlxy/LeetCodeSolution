package com.cyanflxy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-count/description/
 * <p>
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * <pre>
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 * </pre>
 * <pre>
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * </pre>
 * Notes:
 * <ul>
 * <li>The length of cpdomains will not exceed 100.</li>
 * <li>The length of each domain name will not exceed 100.</li>
 * <li>Each address will have either 1 or 2 "." characters.</li>
 * <li>The input count in any count-paired domain will not exceed 10000.</li>
 * </ul>
 * Created by cyanflxy on 2018/4/1.
 */

public class _811_Subdomain_Visit_Count {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _811_Subdomain_Visit_Count object = new _811_Subdomain_Visit_Count();
        System.out.println(object.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(object.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }

        Map<String, Integer> values = new HashMap<>();

        for (String cp : cpdomains) {
            int blank = cp.indexOf(' ');

            int count = Integer.valueOf(cp.substring(0, blank));
            String domain = cp.substring(blank + 1);
            putInMap(values, domain, count);

            int first = domain.indexOf('.');
            if (first >= 0) {
                putInMap(values, domain.substring(first + 1), count);

                int second = domain.indexOf('.', first + 1);
                if (second >= 0) {
                    putInMap(values, domain.substring(second + 1), count);
                }
            }

        }

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    private void putInMap(Map<String, Integer> map, String key, int value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }
}
