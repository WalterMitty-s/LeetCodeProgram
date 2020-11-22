package com.company.CSP.CCF202009;

import java.util.Scanner;
import static java.lang.Math.acos;

public class Four {
    /**
     * 题目：202009-4
     * 解法：
     *      没有思路：
     *          参考文章
     *              https://blog.csdn.net/weixin_44347347/article/details/108952630?utm_medium=distribute.pc_relevant.none-task-blog-title-2&spm=1001.2101.3001.4242
     *              https://blog.csdn.net/qq_43400598/article/details/108943029
     *      大多以数学方式来思考
     * 结果：超时，获得95
     * @param args
     */
    public static void main(String[] args) {
        int n,m,r;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        r=scanner.nextInt();
        int[] o=new int[n];     //星球中心坐标
        double[][] p = new double[m][n];    //旅行的目标
        double[][] result=new double[m][m];     //二维数组存储每个点到其它点的距离
        double[] d = new double[m]; //每个点到星球中心距离
        double[] rd=new double[m];  //对于其它点，每个点到星球的最短距离，注意是切线，只有在相连直线经过星球 时有用

        for(int i=0;i<n;i++){
            o[i]=scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            double temp=0;
            for (int j = 0; j < n; j++) {
                temp+=(p[i][j]-o[j])*(p[i][j]-o[j]);    //
            }
            d[i] = Math.sqrt(temp);
            rd[i]=Math.sqrt(temp-r*r);

        }

        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                double temp=0;
                for(int k=0;k<n;k++)
                    temp+=(p[i][k]-p[j][k])*(p[i][k]-p[j][k]);

                //计算h
                double x=Math.sqrt(temp);
                double pp=(d[i]+d[j]+x)/2;
                double s=Math.sqrt(pp*(pp-x)*(pp-d[i])*(pp-d[j]));//海伦-秦九韶公式
                double h=2*s/x;

                //判断是否经过星球
                if(h>=r||(x*x+d[i]*d[i]<=d[j]*d[j])||(x*x+d[j]*d[j]<=d[i]*d[i]))
                {
                    result[i][j]=result[j][i]=x;
                    continue;
                }

                //计算点到点的距离
                double angle1=acos((d[i]*d[i]+d[j]*d[j]-x*x)/(2*d[i]*d[j]));
                double angle2=acos(r/d[i]);
                double angle3=acos(r/d[j]);
                result[i][j]=result[j][i]=(angle1-angle2-angle3)*r+rd[i]+rd[j];
            }
        }
        for(int i=0;i<m;i++)
        {
            double sum=0;
            for(int j=0;j<m;j++)
            {
                if(i==j) continue;
                sum+=result[i][j];
            }
            System.out.printf("%.14f\n",sum);   //格式化输出
        }
    }
}
