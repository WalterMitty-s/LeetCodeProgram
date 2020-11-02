package com.company.Base.AboutHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class Solution217 {
    /**
     * 类型：简单
     * 自己完成：HashMap
     *      没必要使用map，可以参照官方直接使用set
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(!hashMap.containsKey(num))
                hashMap.put(num,1);
            else
                hashMap.put(num,hashMap.get(num)+1);
        }
        for(int num:hashMap.values()){
            if(num>1)
                return true;
        }
        return false;
    }

    /**
     * 官方解法：使用HashSet
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}
