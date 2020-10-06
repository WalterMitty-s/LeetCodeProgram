package com.company;

import com.company.Array.BianLi.Solution485;
import com.company.Find.Solution50;

public class Main {
    public static void main(String[] args) {
        Solution485 solution=new Solution485();
        int[] nums=new int[]{1,1,0,1,1,1};
        int num=solution.findMaxConsecutiveOnes(nums);
        System.out.println(num);

    }
}

