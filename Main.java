package com.company;

import com.company.Array.BianLi.Solution485;
import com.company.Array.BianLi.Solution495;
import com.company.Array.TongJi.Solution41;
import com.company.Array.TongJi.Solution442;
import com.company.Array.TongJi.Solution448;
import com.company.Array.TongJi.Solution645;
import com.company.Find.Solution50;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution41 solution=new Solution41();
        int[] nums=new int[]{0,1,1,2,2};
        int rs=solution.firstMissingPositive2(nums);
        System.out.println(rs);
    }
}

