package com.company.Base.StackAndDiGui;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 */
public class Solution71 {
    /**
     * 自己没有想出来，直接参考题解：使用栈数据结构求解
     */
    /**
     * 非官方解法：
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (String s : str) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(s) && !".".equals(s)) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }
}
