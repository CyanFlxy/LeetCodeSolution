package com.cyanflxy.leetcode._7;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author cyanflxy
 * @since 2021.07.13
 */
public class _726 {
    private int index = 0;

    public String countOfAtoms(String formula) {
        Atoms list = listCount(formula);
        StringBuilder sb = new StringBuilder();

        for (Atom atom : list.atomCount.values()) {
            sb.append(atom.name);
            if (atom.count > 1) {
                sb.append(atom.count);
            }
        }

        return sb.toString();
    }

    private Atoms listCount(String formula) {
        Atoms result = new Atoms();

        String lastName = "";
        Atoms lastList = null;
        int count = 0;

        while (index < formula.length()) {
            char ch = formula.charAt(index);
            index++;

            if (ch == '(') {
                addAtom(result, lastName, lastList, count);

                lastList = listCount(formula);
                lastName = "";
                count = 0;
            } else if (ch == ')') {
                break;
            } else if (ch >= '0' && ch <= '9') {
                count = count * 10 + ch - '0';
            } else if (ch >= 'a' && ch <= 'z') {
                lastName += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                addAtom(result, lastName, lastList, count);

                lastList = null;
                lastName = String.valueOf(ch);
                count = 0;
            }
        }

        addAtom(result, lastName, lastList, count);

        return result;
    }

    private void addAtom(Atoms result, String lastName, Atoms lastList, int count) {
        if (lastName.length() > 0) {
            result.add(new Atom(lastName, count));
        } else if (lastList != null) {
            lastList.multi(count);
            result.add(lastList);
        }
    }

    class Atoms {
        Map<String, Atom> atomCount = new TreeMap<>();

        void add(Atom atom) {
            if (atomCount.containsKey(atom.name)) {
                atomCount.get(atom.name).count += atom.count;
            } else {
                atomCount.put(atom.name, atom);
            }
        }

        void add(Atoms atoms) {
            for (Atom atom : atoms.atomCount.values()) {
                add(atom);
            }
        }

        void multi(int times) {
            if (times == 0) {
                return;
            }

            for (Atom atom : atomCount.values()) {
                atom.count *= times;
            }
        }
    }

    class Atom {
        String name;
        int count;

        public Atom(String name, int count) {
            this.name = name;
            if (count == 0) {
                this.count = 1;
            } else {
                this.count = count;
            }
        }
    }
}
