package com.company.CSP.CCF202009;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        int n,k,t;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();    //人数
        k=scanner.nextInt();    //连续
        t=scanner.nextInt();    //记录数
        int x1,y1,x2,y2;
        x1=scanner.nextInt();
        y1=scanner.nextInt();
        x2=scanner.nextInt();
        y2=scanner.nextInt();
        int[][] result=new int[n][2];
        int x,y;
        int numOfSerial;
        for(int i=0;i<n;i++){
            result[i][0]=0;
            result[i][1]=0;
            numOfSerial=0;
            for(int j=0;j<t;j++){
                x=scanner.nextInt();
                y=scanner.nextInt();
                if(x>=x1&&x<=x2&&y>=y1&&y<=y2){
                    result[i][0]=1;
                    numOfSerial++;
                    if(numOfSerial>=k){
                        result[i][1]=1;
                    }
                }
                else {
                    numOfSerial=0;
                }
            }
        }
        int res1=0,res2=0;
        for(int i=0;i<n;i++){
            if(result[i][0]==1){
                res1++;
            }
            if(result[i][1]==1){
                res2++;
            }
        }
        System.out.println(res1);
        System.out.println(res2);

    }
}
