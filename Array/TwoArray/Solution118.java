package com.company.Array.TwoArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Solution118 {
    /**
     * 非官方解法：
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    list.add(1);
                else {
                    list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }

            }
            result.add(list);
        }
        return result;
    }

}
