package com.company.Base.Array.TongJi;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class Solution697 {
    /**
     * 自己未完成：
     *      使用一个Map
     * @param nums
     * @return
     */
    /*
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 0);
            }
        }
        int max=Collections.max(map.values());
        return 0;
    }

     */

    /**
     * 官方解法：
     *      使用三个map记录
     * @param nums
     * @return
     */
    public int findShortestSubArray2(int[] nums) {
        Map<Integer,Integer> left=new HashMap<>(),right=new HashMap<>(),count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(left.get(nums[i])==null)
                left.put(nums[i],i);
            right.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }

        int ans=nums.length;
        int degree= Collections.max(count.values());
        for (int x:count.keySet()){
            if(count.get(x)==degree){
                ans= Math.min(ans,right.get(x)-left.get(x)+1);
            }
        }

        return ans;
    }
}
