package com.company.Base.Array.XuanZhuan;

public class Solution396 {
    /**
     * 未做出，未看题解
     * 超出时间限制：
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        if(A.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        for(int k=0;k<A.length;k++){
            int count=0;
            int result=0;
            int numOfMove=1;
            for(int start=0;count<A.length;start++){
                if(k==0)
                    break;
                int prev=A[start];
                int current = start;
                do {
                    int next=(current+numOfMove)%A.length;
                    int temp=A[next];
                    A[next]=prev;
                    prev=temp;
                    current=next;
                    count++;
                } while (start != current);
            }

            for(int i=0;i<A.length;i++){
                result=result+i*A[i];
            }
           max=Math.max(result,max);
        }
        return max;
    }
}
