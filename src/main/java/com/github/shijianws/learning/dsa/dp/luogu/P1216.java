package com.github.shijianws.learning.dsa.dp.luogu;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author shijian
 * @email shijian@gomefinance.com.cn
 * @date 2022-10-22
 */
public class P1216 {
    // https://www.luogu.com.cn/problem/P1216
    public static void main(String[] args) {
        /*
                    7
                  3   8
                8   1   0
              2   7   4   4
            4   5   2   6   5
            7
            3   8
            8   1   0
            2   7   4   4
            4   5   2   6   5
                   7
                10   15
              18   16  15
             20  25  20  19
            24  30  27  26  24
         */
        int[][] matrix = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int[][] dp = new int[matrix.length][matrix.length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0, k = matrix[i].length; j < k; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else if (j == k - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + matrix[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
                }
            }
        }
        System.out.println(Stream.of(dp).map(Arrays::toString).collect(Collectors.joining("\n")));
        System.out.println(IntStream.of(matrix.length).max().getAsInt());
    }



}
