package com.company.Base.Array.TwoArray;

public class Solution661 {
    /**
     * 自己做：未完成
     * 遍历矩阵进行计算，不通用，无法写下去
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] result = new int[row][col];
        /*
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0) {
                    if (j == 0) {
                        result[i][j] = (int) Math.floor((M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1]) / 4);
                    }
                    if (j == col - 1) {
                        result[i][j] = (int) Math.floor((M[i][j - 1] + M[i + 1][j - 1] + M[i + 1][j]) / 4);
                    }
                } else if (i == row - 1) {
                    if (j == 0) {
                        result[i][j] = (int) Math.floor((M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1]) / 4);
                    }
                    if (j == col - 1) {
                        result[i][j] = (int) Math.floor((M[i - 1][j - 1] + M[i - 1][j] + M[i][j - 1]) / 4);
                    }

                }


            }
        }
        */
        return result;
    }

    /**
     * 官方解法：遍历矩阵
     * 使用四重循环：
     * 外两层循环进行矩阵的遍历
     * 内两层循环进行周围8个单元格的遍历
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother2(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] result=new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int count = 0;
                for (int fr = r - 1; fr <= r + 1; fr++) {
                    for (int fc = c - 1; fc <= c + 1; fc++) {
                        //如果存在邻居则运算
                        if(fr>=0&&fr<row&&fc>=0&&fc<col){
                            result[r][c]+=M[fr][fc];
                            count++;
                        }
                    }
                }
                result[r][c]=result[r][c]/count;
            }
        }
        return result;
    }
}
