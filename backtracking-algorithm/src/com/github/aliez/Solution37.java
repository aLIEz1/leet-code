package com.github.aliez;

/**
 * 37 解数独
 *
 * @author lm
 * @date 2021/4/16 16:57
 */
public class Solution37 {

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                //找到9也没有找到合适的，直接返回
                return false;
            }
        }
        return true;

    }

    private boolean isValid(int row, int col, char val, char[][] board) {
        // 判断行里是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 判断列里是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 判断9方格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int n = board[0].length;
        backtracking(board);
    }


}
