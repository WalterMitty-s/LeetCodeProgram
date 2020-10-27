package com.company.Base.Array.TeDingOrder;

import java.util.ArrayList;
import java.util.Collections;

public class Solution498 {
    /**
     * 官方解法：对角线迭代和翻转
     *      思路：
     *      解决许多复杂问题的常见策略是首先解决该问题的简化问题，然后考虑从简化问题到原始问题需要做哪些修改，方法一就是这种思路。
     *      首先考虑按照逐条对角线打印元素，而不考虑翻转的情况。
     * @param matrix
     * @returkn
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int row = matrix.length;      //row
        int col = matrix[0].length;   //col

        int[] result = new int[row * col];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        for (int d = 0; d < row + col - 1; d++) {
            intermediate.clear();
            int r = d < col ? 0 : d - col + 1;
            int c = d < col ? d : col - 1;

            while (r < row && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
