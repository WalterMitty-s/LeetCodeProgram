package com.company.Base.TanXin;

import java.util.Arrays;

public class Solution561 {
    /**
     * 自己完成：
     * 思路：
     *      排序后两两分组选择（a,b）结果为所有a的和
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<nums.length;i=i+2){
            result=result+nums[i];
        }
        return result;
    }
}
