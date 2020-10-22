package com.company.Base.Find;

public class Solution69 {
    /**
     * 自己参考x/m
     * @param x
     * @return

     */
    /* 会溢出，导致结果出错
     * int i = 1;
     * while (i * i <= x) {
     * i++;
     * }
     * return i-1;
     */
    public int mySqrt(int x) {
        int m = 1;
        while (x / m >= m) {
            m++;
        }
        return m-1;
    }

    /**
     * 官方解法：
     * 二分查找：
     *  时间复杂度：O(logx) 空间复杂度：O(1)
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (r>=l){
            int mid=l+(r-l)/2;
            if((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return ans;
    }
}
