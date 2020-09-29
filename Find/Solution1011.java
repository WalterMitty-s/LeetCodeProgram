package com.company.Find;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class Solution1011 {
        /**
         * 非官方解法：
         *      二分查找
         * 算法：
         * 定义函数canShip(D, K)canShip(D,K),来判断在最低承载力为KK的情形下能否在DD天内送达所有包裹。我们所要做的就是按照传送带上货物的顺序，
         * 依次且尽可能多地往船上装载货物，当该艘船无法装下更多货物时，我们换一搜船，同时将天数加11。当运输完所有货物后，我们判断所用的天数是否小于等于DD。
         * 用二分查找的方式，来查找这个最低承载力，如果midmid可以完成任务，我们把查找范围缩减至[lo, mid][lo,mid]（注意不是mid+1mid+1,因为midmid可能是
         * 我们所求的解），否则我们去[mid+1, hi][mid+1,hi]区间中继续查找，详情见代码。
         * @param weights
         * @param D
         * @return
         */
        public int shipWithinDays(int[] weights, int D) {
                int low=0,high=Integer.MAX_VALUE;
                while (low<high){
                        int mid=(low+high)/2;
                        if(canShip(weights,D,mid)){
                                high=mid;
                        }
                        else {
                                low=mid+1;
                        }
                }
                return low;
        }

        private boolean canShip(int[] weights,int D,int K){
                int cur=K;              //cur代表当前承载量
                for(int weight:weights){
                        if(weight>K)
                                return false;
                        if(cur<weight){
                                cur=K;
                                D--;
                        }
                        cur=cur-weight;
                }
                return D>0;             //能否在D天内完成
        }
}
