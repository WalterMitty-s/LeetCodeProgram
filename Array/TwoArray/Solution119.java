package com.company.Array.TwoArray;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<rowIndex;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    list.add(1);
                else {
                    list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result.get(rowIndex-1);
    }
    /**
     * 非官方解法：
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

    /*
        非官方解法：从后遍历
    int* getRow(int rowIndex, int* returnSize) {
        *returnSize = rowIndex + 1;
        int* num = (int*) malloc ((rowIndex + 1) * sizeof(int));
        for(int i = 0;i <= rowIndex;i++)
            for(int j = i;j >= 0;j--)
            {
                if(j == 0 || j == i)
                    num[j] = 1;
                else
                    num[j] = num[j] + num[j-1];
            }
        return num;
    }
     */
}
