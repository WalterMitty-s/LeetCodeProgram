package com.company;

import java.util.Arrays;

/**
 * 官方方法：未写出来
 */
public class Solution242 {
    /**
     * 哈希
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] alpha=new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
            alpha[t.charAt(i)-'a']--;
        }
        for(int i=0;i<alpha.length;i++){
            if(alpha[i]!=0)
                return false;
        }
        return true;
    }
    /**
     * 排序
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] sarr=s.toCharArray();
        char[] tarr=t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr,tarr);
    }
}
