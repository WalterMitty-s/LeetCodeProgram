package com.company.Find;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
 * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 */
public class Solution1300 {
    /**
     * 没有思路
     * 官方解法：
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);                   //进行排序
        int len=arr.length;                 //arr数组长度
        int[] prefix=new int[len+1];        //前缀和
        for(int i=1;i<=len;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        int r=arr[len-1];
        int ans=0,diff=target;
        for(int i=0;i<=r;i++){
            int index=Arrays.binarySearch(arr,i);
            if (index < 0) {
                index=-index-1;
            }
            int cur=prefix[index]+(len-index)*i;
            if(Math.abs(cur-target)<diff){
                ans=i;
                diff=Math.abs(cur-target);
            }
        }
        return ans;
    }
}
