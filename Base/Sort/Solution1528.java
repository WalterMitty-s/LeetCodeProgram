package com.company.Base.Sort;

public class Solution1528 {
    /**
     * 自己完成：使用辅助字符数组存储后转为字符串返回
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] res=new char[indices.length];
        int count=0;
        for (int i=0;i<indices.length;i++){
            for(int j=0;j<indices.length;j++){
                if(indices[j]==count){
                    res[count]=s.charAt(j);
                    count++;
                }
            }
        }
        return new String(res);
    }

    /**
     * 辅助数组：这里只使用了一次扫描，而我用了两重循环
     * @param s
     * @param indices
     * @return
     */
    public String restoreString2(String s, int[] indices) {
        int length=indices.length;
        char[] res=new char[length];
        for(int i=0;i<length;i++){
            res[indices[i]]=s.charAt(i);
        }
        return new String(res);
    }
}
