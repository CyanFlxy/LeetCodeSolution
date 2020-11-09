package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/3
 */
public class _1268 {

    public static void main(String... args) {
        List<List<String>> result = new _1268().suggestedProducts(
                new String[]{"bags", "baggage", "banner", "box", "cloths"},
                "bags");
        System.out.println(result);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int productCount = products.length;
        int len = searchWord.length();

        int startId = 0;
        List<List<String>> result = new ArrayList<>();

        for (int count = 1; count <= len; count++) {
            List<String> arr = new ArrayList<>();

            String search = searchWord.substring(0, count);

            for (int i = startId; i < productCount; i++) {
                if (!products[i].startsWith(search)) {
                    if (arr.size() != 0) {
                        break;
                    } else {
                        startId = i + 1;
                    }
                } else {
                    arr.add(products[i]);
                    if (arr.size() == 3) {
                        break;
                    }
                }
            }

            result.add(arr);
        }

        return result;
    }
}
