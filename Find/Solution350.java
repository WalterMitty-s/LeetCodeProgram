package com.company.Find;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution350 {
    /**
     * 官方解法：排序
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1=nums1.length;
        int len2=nums2.length;
        int[] temp=new int[Math.min(len1,len2)];
        int index1=0,index2=0,index=0;
        while (index1<len1&&index2<len2){
            if(nums1[index1]==nums2[index2]){
                temp[index++]=nums1[index1];
                index1++;
                index2++;
            }
            else if(nums1[index1]<nums2[index2]){
                index1++;
            }
            else {
                index2++;
            }
        }
        return Arrays.copyOfRange(temp,0,index);
    }

    /**
     * 官方解法：哈希表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        //nums1.length小
        if(nums1.length>nums2.length)
            return intersect(nums2,nums1);
        HashMap<Integer,Integer> hashMap=new HashMap();
        for(int num:nums1){
            int count=hashMap.getOrDefault(num,0) +1;
            hashMap.put(num,count);
        }
        int[] result=new int[nums1.length];
        int index=0;
        for(int num:nums2){
            int count=hashMap.getOrDefault(num,0);
            if(count>0){
                result[index++]=num;
                count--;
                if(count>0){
                    hashMap.put(num,count);
                }
                else {
                    hashMap.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
