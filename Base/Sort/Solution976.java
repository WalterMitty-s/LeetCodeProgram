package com.company.Base.Sort;

public class Solution976 {

    public int largestPerimeter(int[] A) {
		/*
		假设我们已经知道 cc 的长度了，我们没有理由不从数组中选择尽可能大的 aa 与 bb。因为当且仅当 a + b > ca+b>c 的时候，它们才能组成一个三角形。
		*/
        sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }

    /**
     * 使用快速排序
     * @param a
     */
    public void sort(int[] a){
        sort(a,0,a.length-1);
    }

    public void sort(int[] a,int low,int high){
        if(high<=low)
            return;
        int mid=partition(a,low,high);
        sort(a,low,mid-1);
        sort(a,mid+1,high);
    }

    public int partition(int[] a,int low,int high){
        int t=a[low];
        int i=low,j=high+1;
        while(true){
            while(a[++i]<t){
                if(i==high)
                    break;
            }
            while (a[--j]>t){
                if(j==low)
                    break;
            }
            if(i>=j)
                break;
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        int temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        return j;
    }

}
