package com.company.Base.Array.TongJi;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
 */
public class Solution41 {
    /**
     * 自己完成：
     *      解法：
     *          首先排序，然后去重，最后和1，2，3，4....比较
     *      时间复杂度：不符合题意
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                continue;
            else {
                if (i < nums.length - 1 && nums[i] == nums[i + 1])
                    continue;
                if (nums[i] == result) {
                    result++;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 官方解法：哈希表打标记
     *      时间复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0)
                nums[i]=n+1;
        }
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            if(num<=n)
                nums[num-1]=-Math.abs(nums[num-1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }

        }
        return n+1;
    }

    /**
     * 官方解法：置换：未看
     * @param nums
     * @return
     */
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
