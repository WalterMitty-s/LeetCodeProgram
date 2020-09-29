package com.company.Find;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文
 *  分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 */
public class Solutiond275 {
    /**
     * 题目：c = citation[i] 大于或等于 n - i即可  即为终止条件
     */
    /**
     * 自己思考：不符合题意：线性查找
     * 从后往前查找，与官方解法相比，顺序错误
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len=citations.length;
        for (int i=0;i<len;i++){
            if(citations[len-1-i]<=i+1)
                return i+1;
        }
        return 0;
    }
    /**
     * 官方解法：线性查找
     *  从前到后查找
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        int len=citations.length;
        for (int i=0;i<len;i++){
            if(citations[i]>=len-i)
                return len-i;
        }
        return 0;
    }
    /**
     * 官方解法：二分查找
     * 条件
     */
}
