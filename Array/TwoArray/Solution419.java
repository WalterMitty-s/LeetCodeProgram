package com.company.Array.TwoArray;

public class Solution419 {
    /**
     * 非官方解法：寻找战舰头部
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int row = board.length, col = board[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == '.')              //空位
                    continue;
                if(i>0 && board[i-1][j]=='X')       //左边
                    continue;
                if(j>0 && board[i][j-1]=='X')       //上边
                    continue;
                res+=1;
            }
        }
        return res;
    }
}
