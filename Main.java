package com.company;

import com.company.Find.*;
import com.company.Sort.*;

public class Main {

    public static void main(String[] args) {
        Solutiond275 solution=new Solutiond275();
        int[][] matrix={
                {1,   3,  5,  7},
                {23, 30, 34, 50},
                {10, 11, 16, 20}
                    };
        int[][] matrix2={{}};
        int target=1;
        int[] num1={0,1,3,5,6};
        int[] num2={2,2};
        int result=solution.hIndex(num1);
        System.out.println(result);


    }
}

