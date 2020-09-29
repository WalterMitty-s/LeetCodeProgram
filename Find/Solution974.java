package com.company.Find;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 */
public class Solution974 {
    /**
     * 暴力解法：超时
     * 未自己完成：参考
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int val=0;
        for (int i = 0; i < len; i++) {
            int sum=0;
            for(int j=i;j<len;j++){
                sum=sum+A[j];
                if(sum%K==0)
                    val++;
            }
        }
        return val;
    }
    /**
     * 同余定理
     * 用S(i)表示数组中0到i数字的总和，如果S(j)与S(i)对k取余得到的结果是相同的， 也就是S(j) - S(i) = nK ( n > 0 )，
     * 那么表示数组 i 到 j 的元素能构成一个这样的子数组。 仔细想一下，这个还是有点意思的
     * 不管取余的结果是多少，两者相减后这个值正好就去掉了，最后都是S(j) - S(i) = nK ( n > 0 )。 第一种方法是当遇到了 j ,
     * 用map存储来判断前面有多少种 i 第二种方法是把 i 和 j 都统计起来，最后在里面选择两个来当作 i 和 j 同余的基础是一样的
     */

    /**
     * 方法一：哈希表+逐一统计
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK2(int[] A, int K){
        Map<Integer,Integer> record=new HashMap<>();
        //我们沿着数组对每个p[i]取模，当a=p[i] mod K第一次出现，如果a==0, 即其本身能被K整除，那么这个第一次就要被计入到总数中，其他情况第一次不计入。
        record.put(0,1);
        int sum=0,ans=0;
        for(int e:A){
            sum=sum+ e;
            //Java取模特殊，当被除数为负数时，结果为负数，需纠正
            int modulus=(sum%K+K)%K;
            int same=record.getOrDefault(modulus,0);
            ans+=same;
            record.put(modulus,same+1);
        }
        return ans;
    }

    /**
     * 方法二：
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK3(int[] A, int K){

        return 0;
    }
}