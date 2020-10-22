package com.company.Base.Array.BianLi;

import java.util.TreeSet;

public class Solution414 {
    /**
     * 非官方代码：使用集合
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("error");

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) set.remove(set.first());    //set.first()最小的元素
        }

        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }

}
