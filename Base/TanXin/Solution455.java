package com.company.Base.TanXin;

import java.util.Arrays;

/**
 * 类型：简单
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i, j = 0;
        int result = 0;
        for (i = 0; i < g.length && j < s.length; i++) {
            while (j<s.length) {
               if(s[j]>=g[i]){
                   j++;
                   result++;
                   break;
               }else{
                   j++;
               }
            }
        }
        return result;
    }

    /**
     * 非官方解法：
     *      其实可以用较大大的饼干优先满足可以满足的胃口大的小孩。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index=s.length-1;
        int result = 0;
        for (int i=g.length-1;i>=0;i--) {
            if(index>=0&&s[index]>g[i]){
                result++;
                index--;
            }
        }
        return result;
    }
}
