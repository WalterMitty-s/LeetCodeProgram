package com.company.PATBasicLevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution1020 {
    public static void main(String[] args) {
        double num,need;
        Scanner scanner=new Scanner(System.in);
        num=scanner.nextDouble();
        need=scanner.nextDouble();
        double[][] cake=new double[(int) num][3];
        for(int i=0;i<2;i++){
            for(int j=0;j<num;j++){
                cake[j][i]=scanner.nextDouble();
            }
        }
        for(int i=0;i<num;i++){
            cake[i][2]=cake[i][1]/cake[i][0];
        }

        Arrays.sort(cake, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[2]-o2[2]<0)
                    return 1;
                else if(o1[2]-o2[2]>0)
                    return -1;
                else
                    return 0;
            }
        });
        for(int i=0;i<num;i++){
            System.out.println(cake[i][0]+" "+cake[i][1]+" "+cake[i][2]);
        }
        double ans=0;
        for(int i=0;i<num;i++){
            if(cake[i][0]<=need){
                need=need-cake[i][0];
                ans=ans+cake[i][1];
            }
            else {
                ans=ans+cake[i][2]*need;
                break;
            }
        }
        System.out.printf("%.2f",ans);
    }
}
