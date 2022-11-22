package com.github.shijianws.learning.dsa.dp.luogu;

import com.sun.source.tree.IfTree;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author shijian
 * @email shijian@gomefinance.com.cn
 * @date 2022-10-22
 */
public class P1439 {
    // https://www.luogu.com.cn/problem/P1439
    public static void main(String[] args) {
        System.out.println(lis("2 7 1 5 6 4 3 8 9"));
        System.out.println(lis2("2 7 1 5 6 4 3 8 9"));
        System.out.println(lis2("3 1 2 6 4 5 10 7"));
        System.out.println(lcs("176234", "1232176212321r234sdwq123423"));
    }

    // 一个序列中的最长上升子序列 LIS
    public static int lis(String value) {
        int[] seqs = Stream.of(value.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[seqs.length];
        int[] from = new int[seqs.length];
        // 当前字符本身就是一个子序列
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seqs[j] < seqs[i] && dp[i] <= dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    from[i] = j;
                }
            }
        }


        int pos = 0;
        for (int i = 1, k = dp[0]; i < dp.length; i++) {
            if (k < dp[i]) {
                k = dp[i];
                pos = i;
            }
        }
        print(from, pos);

        return Arrays.stream(dp).max().getAsInt();
    }

    private static void print(int[] arrays, int x) {
        if (x == 0) {
            return;
        }
        int data = arrays[x];
        print(arrays, data);
        System.out.println(data);
    }

    public static int lis2(String value) {
        int[] seqs = Stream.of(value.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[seqs.length];
        int pos = 0;
        for (int i = 0; i < seqs.length; i++) {
            if (pos == 0 || lis[pos - 1] < seqs[i]) {
                lis[pos++] = seqs[i];
                continue;
            }

            // 二分
            int left = 0;
            for (int right = pos; left <= right; ) {
                int middle = left + ((right - left) >>> 1);
                if (seqs[i] >= lis[middle]) {
                    // 大于等于中间值
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            lis[left] = Math.min(lis[left], seqs[i]);
        }
        return pos;
    }

    // 两个序列中的最长公共子序列 LCS
    public static String lcs(String s1, String s2) {
        return null;
    }
}
