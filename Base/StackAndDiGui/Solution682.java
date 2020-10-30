package com.company.Base.StackAndDiGui;

import java.util.Stack;

/**
 * 棒球比赛
 */
public class Solution682 {
    /**
     * 类型：简单
     * 出错：在与字符串进行比较时，通过leetcode运行时，若通过==比较会出错，通过equals则不会
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("D"))
                stack.push(stack.peek() * 2);
            else if (ops[i].equals("C"))
                stack.pop();
            else if (ops[i].equals("+")) {
                stack.push(stack.peek()+stack.get(stack.size()-2));
            } else {
                int num = Integer.valueOf(ops[i].trim());
                stack.push(num);
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result = result + stack.peek();
            stack.pop();
        }
        return result;
    }
}
