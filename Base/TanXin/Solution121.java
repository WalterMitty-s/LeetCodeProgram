package com.company.Base.TanXin;

public class  Solution121{
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int result=0;   //最大利润
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(result<prices[i]-min)
                result=prices[i]-min;
            min= Math.min(min, prices[i]);
        }
        return result;
    }
}