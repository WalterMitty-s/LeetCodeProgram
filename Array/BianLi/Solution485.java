package com.company.Array.BianLi;

public class Solution485 {
    /**
     * 自己完成： 一次遍历
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;        //对连续的1的个数计数
        int max=0;      //记录个数最大值
        for(int j=0;j<nums.length;j++){
            if(nums[j]==1){
                i++;
            }
            else {
                if(i>max)
                    max=i;
                i=0;
            }
            if(j==nums.length-1){
                if(i>max)
                    max=i;
            }
        }
        return max;
    }

    /**
     * 官方解法：一次遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int count=0;        //对连续的1的个数计数
        int maxCount=0;      //记录个数最大值
        for(int j=0;j<nums.length;j++){
            if(nums[j]==1){
                count++;
            }
            else {
                maxCount=Math.max(count,maxCount);
                count=0;
            }
        }
        return Math.max(maxCount,count);
    }
}
