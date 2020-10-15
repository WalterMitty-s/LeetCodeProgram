package com.company.Array.ChangeAndMove;

import java.util.Arrays;

public class Solution453 {
    /**
     * 官方解法：暴力解法【超时】
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = 0, max = nums.length - 1, count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            if (nums[max] == nums[min]) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i]++;
                }
            }
            count++;
        }
        return count;
    }

    /**
     * 官方解法：暴力解法【改进】
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int min = 0, max = nums.length - 1, count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            int diff = nums[max] - nums[min];
            if (diff == 0) {
                break;
            }
            count += diff;
            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i] = nums[i] + diff;
                }
            }
        }
        return count;
    }

    /**
     * 如果对数组进行排序得到有序数列 aa，可以有效地简化问题。类似于方法二，我们用 diff=max-min 更新数列。但不同的是，我们不需要每次都遍历整个数组来得到最大和最小值，而是可以利用数组的有序性在 O(1)O(1) 时间内找到更新后的最大值和最小值。此外，我们也不需要真的更新数组的值。
     * <p>
     * 为了便于理解，下面逐步讲解该算法。
     * <p>
     * 首先，假设我们在每一步计算 diff 之后正在更新有序数组的元素。下面展示如何在不遍历数组的情况下找到最大最小值。在第一步中，最后的元素即为最大值，因此 diff=a[n-1]-a[0]。我们对除了最后一个元素以外所有元素增加 diff。
     * <p>
     * 现在，更新后的数组开头元素 a'[0] 变成了 a[0]+diff=a[n-1]。因此，a'[0] 等于上一步中最大的元素 a[n-1]。由于数组排过序，直到 i-2 的元素都满足 a[j]>=a[j-1]。因此，更新之后，a'[n-2] 即为最大元素。而 a[0] 依然是最小元素。
     * <p>
     * 于是，在第二次更新时，diff=a[n-2]-a[0]。更新后 a''[0] 会成为 a'[n-2]，与上一次迭代类似。
     * <p>
     * 然后，由于 a'[0] 和 a'[n-1] 相等，在第二次更新后，a''[0]=a''[n-1]=a'[n-2]。于是，最大的元素为 a[n-3]。
     * <p>
     * 于是，我们可以继续这样，在每一步用最大最小值差更新数组。
     * <p>
     * 下面进入第二步。第一步中，我们假设每一步会更新数组 aa 中的元素。但事实上，我们不需要这么做。这是因为，即使是在更新元素之后，我们要登记的 diff 差值也不变，因为 max 和 min 增加的数字相同。
     * <p>
     * 于是，我们可以简单的将数组排序一次， moves=\sum_{i=1}^{n-1} (a[i]-a[0])moves=∑
     * i=1
     * n−1
     * (a[i]−a[0])。
     */
    public int minMoves3(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            result = nums[i] -nums[0];
        }
        return result;
    }
}
