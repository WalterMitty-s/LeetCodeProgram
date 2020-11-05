package com.company.Base.TanXin;

/**
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下
 * 种入 n 朵花？能则返回True，不能则返回False。
 */
public class Solution605 {
    /**
     * 类型：简单
     * 自己完成：贪心
     *      总是考虑当前状态下局部最优(或者较优)的策略，来使全局的结果达到最优(或者较优)
     *      依次遍历数组，如果当前位置满足则进行放置，否则不放置
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1 && flowerbed[0] == 0)
            return true;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (i == len - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }

    /**
     * 官方解法一：
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    /**
     * 官方解法二：
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }
}
