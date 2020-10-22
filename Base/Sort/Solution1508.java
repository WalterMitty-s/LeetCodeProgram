package com.company.Base.Sort;

import java.util.Arrays;

/***
 * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 *
 * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 */
public class Solution1508 {
    /**
     * 官方解法一：排序
     * @param nums
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        int rest=1000000007;
        int[] result=new int[n*(n+1)/2];
        int index=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                result[index++]=sum;
            }
        }
        Arrays.sort(result);
        int num=0;
        for(int i=left-1;i<right;i++){
            num=(num+result[i])%rest;
        }
        return num;
    }

    /**
     * 官方解法二：未看
     * @param nums
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int rangeSum2(int[] nums, int n, int left, int right) {

        return 5;
    }
}
