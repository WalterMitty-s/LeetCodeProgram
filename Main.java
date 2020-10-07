package com.company;

import com.company.Array.BianLi.Solution485;
import com.company.Array.BianLi.Solution495;
import com.company.Find.Solution50;

public class Main {
    public static void main(String[] args) {
        Solution495 solution=new Solution495();
        int[] nums=new int[]{1,2};
        int num=solution.findPoisonedDuration(nums,2);
        System.out.println(num);

    }
}

