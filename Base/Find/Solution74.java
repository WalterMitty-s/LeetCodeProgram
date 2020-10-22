package com.company.Base.Find;

public class Solution74 {
    /**
     * 官方解法：二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    /**
     * 题意理解错误，白做，参考答案后理解题意
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0)
            return  false;
        int n=matrix[0].length;

        int left=0;
        int right=m*n-1;
        int mid;

        int midNum;
        while (left<=right){
            mid=(left+right)/2;
            midNum=matrix[mid/n][mid%n];
            if(target==midNum)
                return true;
            else if(target>midNum){
                left=mid+1;
            }
            else {
                right=mid-1;
            }

        }
        return false;
    }
}
