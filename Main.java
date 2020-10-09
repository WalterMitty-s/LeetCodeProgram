package com.company;

import com.company.Array.BianLi.Solution485;
import com.company.Array.BianLi.Solution495;
import com.company.Array.TongJi.Solution645;
import com.company.Find.Solution50;

public class Main {
    public static void main(String[] args) {
        Solution645 solution=new Solution645();
        int[] nums=new int[]{2,3,3,4,5,6};
        int[] num=solution.findErrorNums(nums);
        System.out.println(num[0]+" "+num[1]);

    }
}

