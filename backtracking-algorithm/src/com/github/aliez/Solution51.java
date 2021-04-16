package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51 N皇后
 *
 * @author lm
 * @date 2021/4/16 16:15
 */
public class Solution51 {

    List<List<String>> ans = new ArrayList<>();
    char[][] chessboard;

    private boolean isValid(int n, int row, int col) {
        //同一列有Q
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //45°对角线有Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        //135°对角线有Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void backtracking(int n, int row) {
        if (row == n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(new String(chessboard[i]));
            }
            ans.add(path);
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backtracking(n, 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }
}
