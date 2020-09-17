package com.company;

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
        int[][] intervals={{1,4},{4,5}};
        Solution56 solution=new Solution56();
        int[][] num=solution.merge(intervals);
        for(int i=0;i<num.length;i++){
                System.out.print(num[i][0]+" "+num[i][1]);
                System.out.println();

        }

    }
}

