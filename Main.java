package com.company;

import com.company.Sort.Solution1561;
import com.company.Sort.Solution56;
import com.company.Sort.Solution853;

public class Main {

    public static void main(String[] args) {
        int target=10;
                //12;
        int[] position = {6,8};
                //{10,8,0,5,3};
        int[] speed = {3,2};
                //{2,4,1,1,3};
        int[] s1561={2,4,5};
        int[][] intervals={{1,4},{4,5}};
        Solution1561 solution=new Solution1561();
//        int[][] num=solution.merge(intervals);
        System.out.println(solution.maxCoins(s1561));

    }
}

