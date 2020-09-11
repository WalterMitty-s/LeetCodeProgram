package com.company;

public class Solution977 {
    /**题目：给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * 解法：先进行平方，再进行排序（插入排序）
     * 自己做
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++)
            A[i]=A[i]*A[i];
        for(int i=1;i<A.length;i++){
            for(int j=i;j>0&&(A[j]<A[j-1]);j--){
                //swap A[i],A[j]
               int temp=A[j];
               A[j]=A[j-1];
               A[j-1]=temp;
            }
        }
        return A;
    }

    /**
     * 双指针法：从中间开始比较
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int length=A.length;
        int[] B=new int[length];
        int j=0;//指示正数
        while(j<length&&A[j]<0)//前后顺序不可颠倒，否则越界
            j++;
        int i=j-1;//指示负数
        int index=0;//B下标
        while(i>=0&&j<length){
            if(A[i]*A[i]<A[j]*A[j]){
                B[index++]=A[i]*A[i];
                i--;
            }
            else{
                B[index++]=A[j]*A[j];
                j++;
            }
        }
        while (i>=0){
            B[index++]=A[i]*A[i];
            i--;
        }
        while (j<length){
            B[index++]=A[j]*A[j];
            j++;
        }
        return B;
    }

    /**
     * 双指针法：分别从左，右进行比较（先放最大的值，避免从中间开始）
     * @param A
     * @return
     */
    public int[] sortedSquares3(int[] A) {
        int[] B=new int[A.length];
        int index=A.length-1;
        int a=0;
        int b=index;
        while (index>=0){
            if(A[a]<0&&A[a]*A[a]>A[b]*A[b]){
                B[index--]=A[a]*A[a];
                a++;
            }
            else {
                B[index--]=A[b]*A[b];
                b--;
            }
        }

        return B;
    }
}
