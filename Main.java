package com.company;

import com.company.Array.BianLi.Solution485;
import com.company.Array.BianLi.Solution495;
import com.company.Array.TongJi.Solution448;
import com.company.Array.TongJi.Solution645;
import com.company.Find.Solution50;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution448 solution=new Solution448();
        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        List<Integer> list=solution.findDisappearedNumbers(nums);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}

