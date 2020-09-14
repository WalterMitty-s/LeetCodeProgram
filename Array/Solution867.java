package com.company;

public class Solution867 {
    /**
     * 双重循环，创建数组，进行赋值
     * 时间复杂度：O(R*C)
     * 空间复杂度：O(R*C)
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int[][] result=new int[A[0].length][A.length];
        for (int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                result[j][i]=A[i][j];
            }
        }
        return result;
    }
}
