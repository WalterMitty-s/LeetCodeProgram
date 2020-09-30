package com.company.Find;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数
 */
public class Solution658 {
    /**
     * 自己完成：
     * 思路：
     * 1.新建二维数组，第一列存放当前元素，第二列存放与x差值
     * 2.以差值进行排序，加入list
     * 3.返回升序的list
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            result[i][0] = arr[i];
            result[i][1] = Math.abs(arr[i] - x);
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < k; i++) {
            list.add(result[i][0]);
        }
        Collections.sort(list);
        return list;
    }

    /**
     * 官方解法：二叉查找和双指针
     * 思路：
     *      如果目标 x 小于等于有序数组的第一个元素，那么前 k 个元素就是答案。
     *      类似的，如果目标 x 大于等于有序数组的最后一个元素，那么最后 k 个元素就是答案。
     *      其他情况，我们可以使用二分查找来找到恰好大于 x 一点点的元素的索引 index 。然后让 low 等于 index 左边 k-1 个位置的索引，high 等于 index 右边 k-1 个位置的索引。我们需要的 kk 个数字肯定在范围 [index-k-1, index+k-1] 里面。所以我们可以根据以下规则缩小范围以得到答案。
     *          如果 low 小于 0 或者 low 对应的元素比 high 对应的元素更接近 x ，那么减小 high 索引。
     *          如果 high 大于最后一个元素的索引 arr.size()-1 或者它比起 low 对应的元素更接近 x ，那么增加 low 索引。
     *          当且仅当 [low, high] 之间恰好有 k 个元素，循环终止，此时范围内的数就是答案。
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int len = list.size();
        if (x <= list.get(0))
            return list.subList(0, k);
        else if (x >= list.get(len - 1))
            return list.subList(len - k, len);
        else {
            int index = Collections.binarySearch(list, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(list.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - list.get(low)) <= (list.get(high) - x))
                    high--;
                else if ((x - list.get(low)) > (list.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return list.subList(low, high + 1);

        }
    }
}
