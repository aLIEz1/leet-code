package com.github.aliez;

import java.util.Stack;

/**
 * 150逆波兰表达式求值
 *
 * @author lm
 * @date 2021/4/2 15:06
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNum(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else if ("+".equals(tokens[i])) {
                int sum = 0;
                for (int i1 = 0; i1 < 2; i1++) {
                    sum += stack.pop();
                }
                stack.push(sum);
            } else if ("-".equals(tokens[i])) {
                int sum = -stack.pop();
                sum += stack.pop();
                stack.push(sum);

            } else if ("*".equals(tokens[i])) {
                int sum = 1;
                for (int i1 = 0; i1 < 2; i1++) {
                    sum *= stack.pop();
                }
                stack.push(sum);

            } else if ("/".equals(tokens[i])) {
                int num1 =stack.pop();
                int num2 =stack.pop();
                stack.push(num2/num1);
            }
        }
        return stack.pop();
    }

    private boolean isNum(String s) {
        try {
            int num = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
