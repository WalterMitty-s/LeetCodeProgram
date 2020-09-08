package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    /**
     * 暴力解法:时间复杂度：O(n*m)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j])
                    set.add(nums1[i]);
            }
        }
        int m=0;
        int[] result=new int[set.size()];
        for(int num:set){
            result[m++]=num;
        }
        return result;

    }

    /**
     * 两个set：
     * 时间复杂度：O(n+m)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        for(int num:nums1)
            set1.add(num);
        HashSet<Integer> set2=new HashSet<>();
        for(int num:nums2)
            set2.add(num);
        if(set1.size()<set2.size())
            return set_inter(set1,set2);
        else
            return set_inter(set2,set1);
    }
    public int[] set_inter(HashSet<Integer> set1,HashSet<Integer> set2){
        int[] result=new int[set1.size()];
        int m=0;
        for (int set:set1)
            if(set2.contains(set))
                result[m++]=set;
        return Arrays.copyOf(result,m);
    }

}
