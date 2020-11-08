package com.company.Base.TanXin;

/**
 * Leetcode 122 买卖股票的最佳时机
 * 类型：简单
 * 实际：不会做，看了题解有动态规划，贪心算法
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 */
public class Solution122 {
    /**
     * 自己未完成
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;

        return max;
    }

    /**
     * 非官方解法：贪心算法
     * 解题思路：
     *
     *     股票买卖策略：
     *         单独交易日： 设今天价格 p1p_1p1​、明天价格 p2p_2p2​，则今天买入、明天卖出可赚取金额 p2−p1p_2 - p_1p2​−p1​ （负值代表亏损）。
     *         连续上涨交易日： 设此上涨交易日股票价格分别为 p1,p2,...,pnp_1, p_2, ... , p_np1​,p2​,...,pn​，则第一天买最后一天卖收益最大，即 pn−p1p_n - p_1pn​−p1​；等价于每天都买卖，即 pn−p1=(p2−p1)+(p3−p2)+...+(pn−pn−1)p_n - p_1=(p_2 - p_1)+(p_3 - p_2)+...+(p_n - p_{n-1})pn​−p1​=(p2​−p1​)+(p3​−p2​)+...+(pn​−pn−1​)。
     *         连续下降交易日： 则不买卖收益最大，即不会亏钱。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int result=0;
        if(prices.length<2)
            return 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]-prices[i-1]>0){
                result = result + prices[i] - prices[i - 1];
            }
        }

        return result;
    }
}
