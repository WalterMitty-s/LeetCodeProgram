package com.company.Array.BianLi;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 */
public class Solution495 {
    /**
     * 自己完成：单次扫描
     * 与官方解法思想一致，但代码没有官方解法简洁
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result=0;
        for(int i=0;i<timeSeries.length;i++){
            if(i==timeSeries.length-1){
                result=result+duration;
            }
            else {
                if(timeSeries[i]+duration<=timeSeries[i+1])
                    result=result+duration;
                else {
                    result=result+timeSeries[i+1]-timeSeries[i];
                }
            }
        }
        return result;
    }

    /**
     * 官方解法：一次扫描
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for(int i = 0; i < n - 1; ++i)
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total + duration;
    }

}
