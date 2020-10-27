package com.company.Base.AboutString;

public class Solution520 {
    /**
     * 简单
     * 自己完成：按照题意执行即可
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        boolean flag = true;
        int len = word.length();
        if(len<=1)
            return true;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                if(len==2)
                    return true;
                for (int i = 2; i < len; i++) {
                    if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                        return false;
                }
            } else {
                if(len==2)
                    return true;
                for (int i = 2; i < len; i++) {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                        return false;
                }
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                    return false;
            }
        }

        return flag;
    }

    /**
     * 非官方解法：
     * 思路：
     *      首先遍历字符串所有字符，统计大写字母个数。
     *      然后分三种情况：
     *      1.大写字母个数为0，或者大写字母个数为字符串长度，说明此时为全大写或者全小写，返回true。
     *      2.首字母大写，大写字母个数为1，说明此时只有首字母大写，返回true。
     * @param word
     * @return
     */
    public boolean detectCapitalUse2(String word) {
        int len = word.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char s = word.charAt(i);
            if (s >= 'A' && s <= 'Z') {
                count++;
            }
        }
        return count == len || count == 0
                || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
