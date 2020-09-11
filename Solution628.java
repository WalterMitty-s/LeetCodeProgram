package com.company;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import java.util.Arrays;

public class Solution628 {
    /**
     * 最大的三个数乘积可能有三种情况
     * 最大三个正数，最小三个负数(这种情况应该删除，不存在这样一种情况为最大值），两个负数一个正数
     * 自己做方法
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int lastThree = nums[length - 1] * nums[length - 2] * nums[length - 3];
        //int firstThree=nums[0]*nums[1]*nums[2];
        int mid = nums[0] * nums[1] * nums[length - 1];
        return Math.max(lastThree, mid);
    }

    /**
     * 线性扫描：只需要找出最后三个数，和最前两个数，比较两种情况即可
     * 时间复杂度：O(n) 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        //min1最小，min2次小
        //max1最大，max2次大，max3次于max2
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3=num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
