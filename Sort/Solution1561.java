package com.company.Sort;

import java.util.Arrays;

public class Solution1561 {
    /**
     * 自己完成
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len=piles.length;
        int result=0;
//        int index=len-2; 官方解法直接两个元素的取，比我这样计算节省时间
        for(int i=0;i<len/3;i++){
//            result=result+piles[index];
            result= result+piles[len-2*(i+1)];
//            index=index-2;
        }
        return result;
    }
}
