package com.company;

public class Main {

    public static void main(String[] args) {


        Solution867 solution=new Solution867();
        int[][] test={{1,2,3,4},{4,5,1,6}};
        int[][] result=solution.transpose(test);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++)
                System.out.print(result[i][j]+" ");
            System.out.println();
        }

    }
}

