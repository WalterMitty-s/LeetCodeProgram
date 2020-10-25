package com.company;

import com.company.Base.TeDingOrder.Solution54;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] nums=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums2=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution54 solution54=new Solution54();
        List<Integer> list=solution54.spiralOrder(nums2);
        list.forEach(number-> System.out.println(number));


    }


}

