package com.company.Base.Array.TongJi;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗
 */
public class Solution442 {
    /**
     * 原地标记：非官方解法：
     *      与Solutio448类似：
     *          448：找出缺失数字      先遍历，再判断
     *          442找出重复数字       在遍历过程中直接进行判断
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int num:nums){
            int index=Math.abs(num)-1;
            if(nums[index]<0)
                result.add(Math.abs(num));
            nums[index]=-nums[index];
        }
        return result;
    }
}
