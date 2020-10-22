package com.company.Base.Array.TongJi;

import java.util.Arrays;

public class Solution645 {
    /**
     * 官方解法：排序
     * 自己想法：
     *      想到排序，找出重复的，但是无法找出{2,3,3,4,5,6}缺失的1
     *      但是在官方解法中直接将missing初始化为1
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

}
