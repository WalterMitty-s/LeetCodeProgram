package com.company.Array.TongJi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
I*/
public class Solution448 {
    /**
     * 官方解法：
     *      空间复杂度：O(n)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],true);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hashMap.containsKey(i))
                list.add(i);
        }
        return list;
    }

    /**
     * 官方解法：(未懂)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int newIndex=Math.abs(nums[i])-1;
            if(nums[newIndex]>0)
                nums[newIndex]=nums[newIndex]*(-1);
        }

        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0)
                list.add(i);
        }
        return list;
    }
}
