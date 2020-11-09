package com.cyanflxy.leetcode._3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _399 {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values, List<List<String>> queries) {
        Map<String, List<Expression>> exps = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String var1 = equation.get(0);
            String var2 = equation.get(1);

            addExp(exps, var1, new Expression(value, var2));
            addExp(exps, var2, new Expression(1 / value, var1));

        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < result.length; i++) {
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);
            result[i] = getValue(exps.get(var1), exps.get(var2));
        }

        return result;
    }

    private void addExp(Map<String, List<Expression>> exps, String var, Expression exp) {
        List<Expression> expList = exps.get(var);
        if (expList == null) {
            expList = new ArrayList<>();
            exps.put(var, expList);
            expList.add(new Expression(1, var));
        }
        expList.add(exp);

        List<Expression> otherExps = exps.get(exp.var);
        if (otherExps == null) {
            return;
        }

        Set<String> equaled = new HashSet<>();
        equaled.add(var);
        equaled.add(exp.var);
        for (Expression e : otherExps) {
            if (equaled.contains(e.var)) {
                continue;
            }

            equaled.add(e.var);
            expList.add(new Expression(exp.num * e.num, e.var));
            exps.get(e.var).add(new Expression(1 / exp.num / e.num, var));
        }
    }

    private double getValue(List<Expression> exp1, List<Expression> exp2) {
        if (exp1 == null || exp2 == null) {
            return -1;
        }

        for (Expression e1 : exp1) {
            for (Expression e2 : exp2) {
                if (e1.var.equals(e2.var)) {
                    return e1.num / e2.num;
                }
            }
        }

        return -1;
    }

    private static class Expression {
        double num;
        String var;

        public Expression(double num, String var) {
            this.num = num;
            this.var = var;
        }
    }
}
