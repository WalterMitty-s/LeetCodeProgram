package com.company.Base.XuanZhuan;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution189 {
    /**
     * 自己完成：暴力法
     * 每次移动进行一次循环
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        while (k-- != 0) {
            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 使用环状替换
     *  环状替代和我的思路一致，不过我觉得这样解释可能更容易理解。把元素看做同学，把下标看做座位，大家换座位。
     *  第一个同学离开座位去第k+1个座位，第k+1个座位的同学被挤出去了，他就去坐他后k个座位，如此反复。但是会出
     *  现一种情况，就是其中一个同学被挤开之后，坐到了第一个同学的位置（空位置，没人被挤出来），但是此时还有人
     *  没有调换位置，这样就顺着让第二个同学换位置。 那么什么时候就可以保证每个同学都换完了呢？n个同学，换n次，
     *  所以用一个count来计数即可
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;

            } while (start != current);
        }
    }

}
