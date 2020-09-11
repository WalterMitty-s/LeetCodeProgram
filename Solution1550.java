package com.company;

public class Solution1550 {
    /**
     * 循环判断
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            if((arr[i]&1)!=0&&(arr[i+1]&1)!=0&&(arr[i+2]&1)!=0)
                return true;
        }
        return false;
    }

    /**
     * LeetCode 非官方题解 通用性高
     * 双指针：i，j两个指针，i指示起始位置，j指示结束位置
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds2(int[] arr) {
        int i=0,j=0;
        for(;j<arr.length;j++){
            if(arr[j]%2==0){
                if(j-i>=3)
                    return true;
                i=j+1;
            }
        }
        //三个奇数出现在数组末尾
        if(j-i>=3)
            return true;
        return false;

    }
}
