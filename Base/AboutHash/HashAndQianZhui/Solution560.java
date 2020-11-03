package com.company.Base.AboutHash.HashAndQianZhui;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class Solution560 {
    /**
     * 理解错题意
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        return 0;
    }

    /**
     * 官方解法：枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 官方解法：前缀和+哈希表优化
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /*
    public int subarraySum(int[] nums, int k) {
        // hash
        // 记录合适的连续字符串数量
        int count=0;
        // 记录前面数字相加之和
        int pre=0;
        // map记录前几个数字之和为K出现相同和的次数为V
        HashMap<Integer,Integer> map = new HashMap<>();
        // 初始化
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+= nums[i];
            // 如果前面数字之和加上这个数字正好等于K（存在一个数字加上nums[i]结果为K
            // 说明找到了
            if (map.containsKey(pre-k)){
                // 累计
                count+=map.get(pre-k);
            }
            // 计算新的和放入map
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

     */
}
