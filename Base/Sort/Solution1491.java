package com.company.Base.Sort;

import java.util.Arrays;

public class Solution1491 {
    /**
     * 使用Arrays.sort() 自己完成
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        Arrays.sort(salary);
        double result=0;
        for(int i=1;i<salary.length-1;i++){
            result=result+salary[i];
        }
        return result/(salary.length-2);
    }

    /**
     * 使用插入排序:自己完成
     * @param salary
     * @return
     */
    public double average2(int[] salary) {
        double sum=0;
        for(int i=1;i<salary.length;i++){
            for(int j=i;j>0&&(salary[j]<salary[j-1]);j--){
                int temp=salary[j-1];
                salary[j-1]=salary[j];
                salary[j]=temp;
            }
        }
        for(int i=1;i<salary.length-1;i++){
            sum=sum+salary[i];
        }
        return sum/(salary.length-2);

    }

    /**
     * 直接使用一次循环
     * @param salary
     * @return
     */
    public double average3(int[] salary) {
        double result=0;
        int min=salary[0],max=salary[0];
        for(int i=0;i<salary.length;i++){
            result=result+salary[i];
            if(max<salary[i])
                max=salary[i];
            if(min>salary[i])
                min=salary[i];
        }
        return (result-max-min)/(salary.length-2);
    }
}
