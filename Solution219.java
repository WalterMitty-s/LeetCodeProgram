package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution219 {
    /**
     * 直接双重循环，进行查找比较
     * 时间复杂度大
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]&&j-i<=k)
                    return true;
            }
        }
        return false;
    }

    /**
     * 使用散列表
     * 时间复杂度O(n) 空间复杂度O(min(n,k))
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> Set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(Set.contains(nums[i]))
                return true;
            Set.add(nums[i]);
            if(Set.size()>k)
                Set.remove(nums[i-k]);
        }
        return false;
    }
}
