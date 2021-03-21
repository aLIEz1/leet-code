package com.github.aliez;

import java.util.Arrays;

/**
 * 59
 * 左闭右开
 *
 * @author lm
 * @date 2021/3/19 15:09
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int startX = 0, startY = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i, j;
        int[][] result = new int[n][n];
        while (loop-- >= 0) {
            i = startX;
            j = startY;

            for (j = startY; j < startY + n - offset; j++) {
                result[startX][j] = count++;
            }
            for (i = startX; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }
            for (; j > startY; j--) {
                result[i][j] = count++;
            }
            for (; i > startX; i--) {
                result[i][j] = count++;
            }
            startX++;
            startY++;
            offset += 2;

        }
        if (n % 2 != 0) {
            result[mid][mid] = count;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        System.out.println(Arrays.deepToString(solution59.generateMatrix(3)));

    }
}
