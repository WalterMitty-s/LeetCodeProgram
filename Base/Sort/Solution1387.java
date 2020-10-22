package com.company.Base.Sort;

import java.util.*;

/**
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 *
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 */
public class Solution1387 {
    /**
     * 自己完成：效率较低
     * 思路：
     *      1.根据题意获取权重，即记录变为1的次数
     *      2.将值和权重看为一行两列的数组
     *      3.利用权重进行排序即可
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        if (len == 1)
            return lo;
        int[][] array = new int[len][2];
        for (int i = 0; i < len;i++){
            array[i][0]=lo+i;
            array[i][1]=getKNum(lo+i);
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });
        for(int i=0;i<len;i++){
            System.out.println(array[i][0]+ " "+array[i][1]);
        }
        return array[k-1][0];

    }

    int getKNum(int num) {
        int numberOfNum = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            numberOfNum++;
        }
        return numberOfNum;
    }

    /**
     * 非官方解法：使用优先队列+记忆化
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth2(int lo, int hi, int k) {
        // int[] = {值，权重}
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        memo = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            heap.offer(new int[]{i, getWeight(i)});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek()[0];
    }
    private Map<Integer, Integer> memo;

    private int getWeight(int num) {
        if (num == 1) {
            return 0;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        int count = (num & 1) == 0 ? getWeight(num >>> 1) : getWeight(3 * num + 1);
        count++;
        memo.put(num, count);
        return count;
    }
}
