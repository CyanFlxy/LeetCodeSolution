package com.cyanflxy.leetcode._6;

import com.cyanflxy.leetcode.help.Utils;

import java.util.*;

/**
 * @author cyanflxy
 * @since 2021.05.20
 */
public class _692 {

    public static void main(String[] args) {
        new _692().topKFrequent(Utils.toArray("i", "a", "x", "i", "a", "x"), 3);
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o1.getValue() - o2.getValue();
            } else {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

}
