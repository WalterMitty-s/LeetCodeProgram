package com.company.Find;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */
public class  Solution167 {
    /**
     * 暴力求解方法：双重循环
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target)
                    return new int[]{i+1,j+1};
            }
        }
        return new int[]{0,0};
    }

    /**
     * 官方解法：双指针
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers,int target){
        int i=0,j=numbers.length-1;
        while (i<j){
            int sum=numbers[i]+numbers[j];
            if(sum<target)
                i++;
            else if(sum>target)
                j--;
            else
               return new int[]{i+1,j+1};
        }
        return new int[]{-1,-1};
    }
}
