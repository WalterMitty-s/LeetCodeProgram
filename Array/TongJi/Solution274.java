package com.company.Array.TongJi;

import java.util.Arrays;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别
 * 被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）
 *
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 */
public class Solution274 {
    /**
     * 自己完成：
     * 文章数量与引用次数进行比较，找到临界值
     *
     * * leetcode同解法思路：
     * *
     * * 1、首先看到h个元素大于等于某个值，N-h个元素小于等于某个值，这显然是一个有序序列的特征，所以自然而然的想到先将数组排序；
     * *
     * * 2、将数组排序之后，对于给定的某个i，我们知道有citations.length - i篇论文的引用数 ≥ citations[i]，i篇
     * *    论文的引用数 ≤ citations[i]；
     * *
     * * 3、不妨设h = citations.length - i，即至多有h篇论文分别引用了至少citation[i]次，其余citations.length - h篇
     * *    论文的引用数不多于citation[i]次。
     * *
     * *    既然如此，只要citation[i] ≥ h，就满足题意。
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (len - i <= citations[i])
                return len - i;
        }
        return 0;
    }

    /**
     * 官方解法：排序
     *
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 线性扫描找出最大的 i
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    /**
     * 官方解法：计数
     *
     * @param citations
     * @return
     */
    public int hIndex3(int[] citations) {
        int n = citations.length;
        //存放各引用次数相同的论文
        int[] papers = new int[n+1];

        for(int citation:citations){
            //将多于n次的论文放到n中，不会影响结果
            papers[Math.min(n,citation)]++;
        }
        //初始化论文类型,找出最大的k
        int k=n;
        for(int s=papers[k];k>s;s=s+papers[k]){
            k--;
        }
        return k;
    }

}
