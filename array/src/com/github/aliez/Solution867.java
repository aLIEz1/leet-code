package com.github.aliez;

/**
 * 867
 *
 * @author lm
 * @date 2021/3/19 15:34
 */
public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
