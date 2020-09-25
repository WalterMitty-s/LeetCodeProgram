package com.company;

import com.company.Find.Solution167;
import com.company.Find.Solution69;
import com.company.Find.Solution74;
import com.company.Sort.*;

public class Main {

    public static void main(String[] args) {
        Solution74 solution=new Solution74();
        int[][] matrix={
                {1,   3,  5,  7},
                {23, 30, 34, 50},
                {10, 11, 16, 20}
                    };
        int[][] matrix2={{}};
        int target=1;
        boolean result=solution.searchMatrix(matrix2,target);
        System.out.println(result);

    }
}

