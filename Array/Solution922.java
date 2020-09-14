package com.company;

import java.util.Stack;

//922. 按奇偶排序数组 II
public class Solution922 {
    /**
     * 两个Stack：分别存储奇数，偶数
     * 比较麻烦，浪费空间时间
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        for(int num:A)
            if(num%2==0)
                stack.add(num);
            else
                stack2.add(num);
        for(int i=0;i<A.length;i++){
            if(i%2==0){
                A[i]=stack.peek();
                stack.pop();
            }
            else{
                A[i]=stack2.peek();
                stack2.pop();
            }

        }
        return A;
    }

    /**
     * 双指针法
     * 将数组分成两个部分，分别是偶数部分 even = A[0], A[2], A[4], ... 和奇数部分 odd = A[1], A[3], A[5], ...。
     * 定义两个指针 i 和 j, 每次循环都需要保证偶数部分中下标 i 之前的位置全是偶数，奇数部分中下标 j 之前的位置全是奇数。
     * 时间复杂度O(N),空间复杂度O(1)
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int j=1;
        for(int i=0;i<A.length;i=i+2){
            if(A[i]%2!=0){
                while (A[j]%2==1){
                    j=j+2;
                }
                //swap A[i],A[j]
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
            }
        }
        return A;
    }

}
