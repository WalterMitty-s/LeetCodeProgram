package com.company.Base.TeDingOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素
 */
public class Solution54 {
    /**
     * 自己未完成：有错误，有实例出现错误
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return result;
        int n = matrix[0].length;
        int up = 0, left = 0, right = n - 1, down = m - 1;
        for (int count = 0; count <= m * n; count++) {
            for (int j = left; j < right; j++) {
                result.add(matrix[up][j]);
                count++;
            }
            for (int i = up; i < down; i++) {
                result.add(matrix[i][right]);
                count++;
            }
            for (int j = right; j > left; j--) {
                result.add(matrix[down][j]);
                count++;
            }
            for (int i = down; i > up; i--) {
                result.add(matrix[i][left]);
                count++;
            }
            up++;
            left++;
            right--;
            down--;
        }
        return result;
    }

    /**
     * 官方解法：
     *      将自己代码改为官方代码，运行成功
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return result;
        int n = matrix[0].length;
        int up = 0, left = 0, right = n - 1, down = m - 1;
        while (up <= down && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[up][j]);
            }
            for (int i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && up < down) {
                for (int j = right - 1; j > left; j--) {
                    result.add(matrix[down][j]);
                }
                for (int i = down; i > up; i--) {
                    result.add(matrix[i][left]);
                }

            }
            up++;
            left++;
            right--;
            down--;
        }
        return result;
    }
}
