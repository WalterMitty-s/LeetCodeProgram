package com.company;

import com.company.Find.Solution167;
import com.company.Find.Solution350;
import com.company.Find.Solution69;
import com.company.Find.Solution74;
import com.company.Sort.*;

public class Main {

    public static void main(String[] args) {
        Solution350 solution=new Solution350();
        int[][] matrix={
                {1,   3,  5,  7},
                {23, 30, 34, 50},
                {10, 11, 16, 20}
                    };
        int[][] matrix2={{}};
        int target=1;
        int[] num1={1,2,2,1};
        int[] num2={2,2};
        int[] result=solution.intersect(num1,num2);
        for(int a:result){
            System.out.print(a+" ");
        }


    }
}

