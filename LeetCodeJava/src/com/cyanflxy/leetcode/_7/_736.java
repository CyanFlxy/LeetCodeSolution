package com.cyanflxy.leetcode._7;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.10
 */
public class _736 {

    public static void main(String[] args) {
        int result;
        result = new _736().evaluate("(let x 3 x 2 x)"); // 2
        System.out.println(result);

        result = new _736().evaluate("(let x 1 y 2 x (add x y) (add x y))"); // 5
        System.out.println(result);

        result = new _736().evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"); // 6
        System.out.println(result);

        result = new _736().evaluate("(let a1 3 b2 (add a1 1) b2) ");// 4
        System.out.println(result);

    }

    private char[] expression;
    private int len;
    private int index;

    public int evaluate(String expression) {
        this.expression = expression.toCharArray();
        len = expression.length();
        index = 0;
        Exp exp = readExp();
        return exp.call(new ArrayList<>());
    }

    private Exp readExp() {
        if (expression[index] == '(') {
            // 一个表达式
            index++;

            String word = readNextWord();
            if ("mult".equals(word) || "add".equals(word)) {
                index++;// 略过关键字后的空格
                Exp left = readExp();
                index++;
                Exp right = readExp();
                index++;// 略过后面的括号

                if ("mult".equals(word)) {
                    return new Mult(left, right);
                } else {
                    return new Add(left, right);
                }

            } else if ("let".equals(word)) {
                index++;// 略过关键字后的空格
                Let let = new Let();

                while (true) {
                    Exp left = readExp();
                    if (expression[index] == ' ') {
                        index++;
                        Exp right = readExp();
                        index++;
                        let.addVar(((Var) left).name, right);
                    } else {
                        let.setExp(left);
                        break;
                    }
                }

                index++;// 略过后面的括号
                return let;
            } else {
                // 是否有可能是个数字？
                return null;
            }

        } else {
            char first = expression[index];
            String word = readNextWord();
            if (first >= 'a' && first <= 'z') {
                return new Var(word);
            } else {
                return new Num(Integer.parseInt(word));
            }
        }

    }

    private String readNextWord() {
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            char ch = expression[index];
            if (ch != ' ' && ch != ')') {
                sb.append(ch);
                index++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    static abstract class Exp {
        abstract int call(List<Map<String, Integer>> vars);
    }

    static class Add extends Exp {
        Exp left;
        Exp right;

        public Add(Exp left, Exp right) {
            this.left = left;
            this.right = right;
        }

        @Override
        int call(List<Map<String, Integer>> vars) {
            return left.call(vars) + right.call(vars);
        }
    }

    static class Mult extends Exp {
        Exp left;
        Exp right;

        public Mult(Exp left, Exp right) {
            this.left = left;
            this.right = right;
        }

        @Override
        int call(List<Map<String, Integer>> vars) {
            return left.call(vars) * right.call(vars);
        }
    }

    static class Let extends Exp {
        List<Pair<String, Exp>> vars = new ArrayList<>();
        Exp exp;

        public Let() {
        }

        void addVar(String name, Exp exp) {
            vars.add(new Pair<>(name, exp));
        }

        public void setExp(Exp exp) {
            this.exp = exp;
        }

        @Override
        int call(List<Map<String, Integer>> vars) {
            Map<String, Integer> myVars = new HashMap<>();
            vars.add(0, myVars);
            for (Pair<String, Exp> var : this.vars) {
                myVars.put(var.getKey(), var.getValue().call(vars));
            }
            int result = exp.call(vars);
            vars.remove(0);
            return result;
        }
    }

    static class Num extends Exp {
        int value;

        public Num(int value) {
            this.value = value;
        }

        @Override
        int call(List<Map<String, Integer>> vars) {
            return value;
        }
    }

    static class Var extends Exp {
        String name;

        public Var(String name) {
            this.name = name;
        }

        @Override
        int call(List<Map<String, Integer>> vars) {
            for (Map<String, Integer> var : vars) {
                if (var.containsKey(name)) {
                    return var.get(name);
                }
            }
            return 0;
        }
    }
}
