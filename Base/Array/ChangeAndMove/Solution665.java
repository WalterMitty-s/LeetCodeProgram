package com.company.Base.Array.ChangeAndMove;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class Solution665 {
    /**
     * 思路：
     *      判断不符合条件的数的位置
     * @param nums
     * @return
     */
//    public boolean checkPossibility(int[] nums) {
//        int count=0;
//        int max=Integer.MIN_VALUE;
//        int len=nums.length;        //数组长度
//        for (int i=0;i<len-1;i++){
//            if(nums[i]>nums[i+1]||nums[i+1]>=max){
//                count++;
//            }
//            else{
//                if(nums[i]>max)
//                    max=nums[i];
//            }
//        }
//        return count>1?false:true;
//    }

    /**
     * 非官方解法：查找索引
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        // 两种改法：
        // 1. nums[i]=nums[i + 1] nums[i]减小 这样的话需要保证 nums[i]>=num[i-1]
        // 2. nums[i + 1]=nums[i] nums[i+1]增大 继续判断即可
        // 如果第一种可以优先使用第一种改法，因为第一种改法不影响后面原本可能正确的
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2>=0 && nums[i-2] > nums[i]) nums[i] = nums[i-1];
            }
        }
        return cnt<=1;
    }

    /**
     * 非官方解法：查找索引
     * @param nums
     * @return
     */
    public boolean checkPossibility2(int[] nums) {
        int len = nums.length;
        if (len <= 2) return true;
        boolean change = false;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (change) return false;
                // 两种改法：
                // 1. nums[i]=nums[i + 1] nums[i]减小 这样的话需要保证 nums[i]>=num[i-1]
                // 2. nums[i + 1]=nums[i] nums[i+1]增大 继续判断即可
                // 如果第一种可以优先第一种改法，因为第一种改法不影响后面原本可能正确的
                if (i != 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                change = true;
            }
        }
        return true;
    }
}
