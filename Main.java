package com.company;

import com.company.Sort.Solution853;

public class Main {

    public static void main(String[] args) {
        int target=10;
                //12;
        int[] position = {6,8};
                //{10,8,0,5,3};
        int[] speed = {3,2};
                //{2,4,1,1,3};
        Solution853 solution=new Solution853();
        int num=solution.carFleet(target,position,speed);
        System.out.println(num);

    }
}

