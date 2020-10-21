package com.company.Array.TwoArray;

public class Solution598 {
    /**
     * 暴力解法：超出内存限制
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int[][] result = new int[m][n];
        for (int i = 0; i < ops.length; i++) {
            for (int j = 0; j < ops[i][0]; j++) {
                for (int k = 0; k < ops[i][1]; k++) {
                    result[j][k] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == result[0][0])
                    count++;
            }
        }
        return count;
    }
    /**
     * 一遍遍历：
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount2(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
