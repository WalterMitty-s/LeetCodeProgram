package com.company.Base.AboutHash.HashAndQianZhui;

/**
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k
 * 的倍数，即总和为 n*k，其中 n 也是一个整数。
 */
public class Solution523 {
    /**
     * 暴力解法：
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        if(k==0){
            for (int i = 1; i < len; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum = sum + nums[j];
                    if (j != i && sum  == 0)
                        return true;
                }
            }
        }
        else {
            for (int i = 1; i < len; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum = sum + nums[j];
                    if (j != i && sum % k == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
