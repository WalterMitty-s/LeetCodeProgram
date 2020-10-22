package com.company.Base.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    /**
     * 自己完成
     * 思路：
     *      1.按数组第0个元素排序，创建Arraylist放置满足条件的区间
     *      2.判断每个区间与下一个区间是否重合，并看是否符合条件加入ArrayList
     *      3.转为数组返回
     * 缺点：
     *      可不创建range对象保存数组值，直接匿名进行排序
     *      可不通过循环创建结果数组
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        ArrayList<range> result=new ArrayList<>();
        range[] ranges=new range[intervals.length];
        for (int i=0;i<intervals.length;i++){
            ranges[i]=new range(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(ranges);
        for(int i=0;i<intervals.length;i++){
            if(i==intervals.length-1){
                result.add(ranges[i]);
                break;
            }
            if(ranges[i].sec>=ranges[i+1].fir){
                ranges[i+1].fir=ranges[i].fir;
                ranges[i+1].sec=ranges[i].sec>ranges[i+1].sec?ranges[i].sec:ranges[i+1].sec;
            }
            else {
                result.add(ranges[i]);
            }
        }
        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0]=result.get(i).fir;
            res[i][1]=result.get(i).sec;
        }
        return res;
    }

    class range implements Comparable<range> {
        public int fir;
        public int sec;

        public range(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }

        @Override
        public int compareTo(range o) {
            return this.fir - o.fir;
        }
    }
}

/**
 * 官方解法：
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        ArrayList<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

