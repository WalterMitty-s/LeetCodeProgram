package com.company.Base.Sort;

import java.util.Arrays;

/*（未理解双指针方法，需要思考）
给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整
个数组是有序的），请返回[-1,-1]。

 */
public class Solution16p16 {
    /**
     * 自己完成
     * 创建一个有序数组，进行比较，记录不相同的位置，返回即可
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        int[] list=new int[2];
        list[0]=-1;
        list[1]=-1;
        if(array.length==0)
            return list;
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        int i = 0, j = array.length-1;
        while (i<array.length&&array[i]==copyArray[i]){
            i++;
        }
        while (j>=0&&array[j]==copyArray[j]){
            j--;
        }
        if(i!=array.length)
            list[0]=i;
        if(j!=-1)
            list[1]=j;
        return list;
    }

    /**
     * （未理解，需思考）
     * 非官方解题思路
     * 默认升序（降序也只是改一点代码，不影响）
     *
     * 原理：如果左侧最大值大于中间的最小值，则一定会被中间序列包括；同理，如果右侧最小值大于中间的最大值，则一定会被中间序列包括。
     *
     * 一遍遍历 + 两个指针（两次扫描可一次遍历完成）
     *
     * 1、从前向后扫描数组，判断当前array[i]是否比max小，是则将last置为当前array下标i，否则更新max;
     *
     * 2、从后向前扫描数组，判断当前array[len - 1 - i]是否比min大，是则将first置位当前下标len - 1 - i，否则更新min;
     *
     * 3、返回{first， last}
     * @param array
     * @return
     */
    public int[] subSort2(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};
    }
}
