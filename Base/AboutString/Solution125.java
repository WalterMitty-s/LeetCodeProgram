package com.company.Base.AboutString;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        boolean flag = true;
        if (len == 0)
            return flag;
        int arrLen = 0;
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)<='z'&&s.charAt(i)>='a')
                arr[arrLen++]=s.charAt(i);
            if(s.charAt(i)<='9'&&s.charAt(i)>='0')
                arr[arrLen++]=s.charAt(i);
            if(s.charAt(i)<='Z'&&s.charAt(i)>='A')
                arr[arrLen++]=Character.toLowerCase(s.charAt(i));
        }
        for(char c:arr)
            System.out.print(c);
        for(int first=0,last=arrLen-1;first<=last;first++,last--){
            if(arr[first]==arr[last]||Math.abs(arr[first]-arr[last])==26)
                continue;
            else
                return false;
        }
        return flag;
    }

    /**
     * 官方解法：筛选+判断
     * 时间复杂度：O(|s|) |s|为s的长度
     * 空间复杂度：O(|1|)
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    /**
     * 官方解法：双指针
     * 时间复杂度：O(|s|) |s|为s的长度
     * 空间复杂度：O(|1|)
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
