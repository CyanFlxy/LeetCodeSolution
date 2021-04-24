package com.cyanflxy.leetcode._6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        List<Integer> ids = new LinkedList<>();
        ids.add(id);
        int result = 0;
        while (ids.size() > 0) {
            int i = ids.remove(0);
            Employee e = map.get(i);
            result += e.importance;
            ids.addAll(e.subordinates);
        }
        return result;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
