package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/10/28
 */
public class _227 {

    public static void main(String... args) {
        int val = new _227().calculate("1+2*5/3+6/4*2");
        System.out.println(val);
    }

    public int calculate(String s) {
        Node root = null;
        Node lastOp = null;

        int currentVal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                currentVal = currentVal * 10 + c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                Node value = new Node();
                value.val = currentVal;
                currentVal = 0;

                final Node op = new Node();
                op.operator = c;
                op.priority = (c == '+' || c == '-') ? 1 : 2;


                if (lastOp == null) {
                    op.left = value;
                    root = op;

                } else if (op.priority > lastOp.priority) {
                    lastOp.right = op;
                    op.left = value;
                    op.parent = lastOp;
                } else {
                    lastOp.right = value;
                    while (lastOp != null && op.priority <= lastOp.priority) {
                        lastOp = lastOp.parent;
                    }

                    if (lastOp == null) {
                        op.left = root;
                        root = op;
                    } else {
                        op.parent = lastOp;
                        op.left = lastOp.right;
                        lastOp.right = op;
                    }

                }

                lastOp = op;
            }
        }

        if (lastOp != null) {
            Node value = new Node();
            value.val = currentVal;
            lastOp.right = value;
            return root.cal();
        } else {
            return currentVal;
        }
    }

    class Node {
        char operator;
        int val;
        int priority;
        Node left;
        Node right;
        Node parent;

        int cal() {
            if (operator != 0) {
                switch (operator) {
                    case '+':
                        val = left.cal() + right.cal();
                        break;
                    case '-':
                        val = left.cal() - right.cal();
                        break;
                    case '*':
                        val = left.cal() * right.cal();
                        break;
                    case '/':
                        val = left.cal() / right.cal();
                        break;
                }
                operator = 0;
            }
            return val;
        }

        @Override
        public String toString() {
            if (operator == 0) {
                return "" + val;
            }
            String leftStr = left == null ? "" : left.toString();
            String rightStr = right == null ? "" : right.toString();
            return leftStr + operator + rightStr;
        }
    }
}
