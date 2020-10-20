package com.company;


import com.company.Array.ChangeAndMove.Solution283;
import com.company.Array.ChangeAndMove.Solution665;
import com.company.Array.TongJi.Solution274;
import com.company.Array.TwoArray.Solution119;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution119 solution=new Solution119();
        List<Integer> list=solution.getRow(3);
        for(Integer num:list){
            System.out.print(num+" ");
        }
    }

}

