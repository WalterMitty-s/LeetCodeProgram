package com.company.Base.AboutString;

public class Solution14 {
    /**
     * 自己完成：类似与纵向扫描
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String result = new String();
        int len = strs.length;              //数组长度
        if(len==0||strs[0].length()==0)
            return "";
        int min=Integer.MAX_VALUE;          //记录最短字符串的长度
        for(int i=0;i<len;i++){
            if(strs[i].length()<min)
                min=strs[i].length();
        }
        for (int i = 0; i < min; i++) {     //对列进行循环
            for (int j = 0; j < len-1; j++) { //对行进行循环
                if(strs[j].charAt(i)==strs[j+1].charAt(i))
                    continue;
                else {
                    return result;
                }
            }
            result = result + strs[0].charAt(i);
        }
        return result;
    }

    /**
     * 官方解法：横向扫描
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 官方解法：纵向扫描
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 官方解法：分治
     * @param strs
     * @return
     */

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }



}
