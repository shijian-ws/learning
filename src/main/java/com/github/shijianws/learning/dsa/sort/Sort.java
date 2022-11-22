package com.github.shijianws.learning.dsa.sort;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 排序
 */
public class Sort {
    public static int[] makeArray(int length) {
        int[] array = new int[length];
        for (int i = 0, j = length >> 1, n = length; i < j; i++) {
            array[i + j] = n--;
            array[i] = n--;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = makeArray(ThreadLocalRandom.current().nextInt(10, 11));
        StringBuilder buf = new StringBuilder();
        Stream.of(Sort.class.getDeclaredMethods()).sorted(Comparator.comparing(Method::getName)).forEach(method -> {
            if (!Modifier.isPublic(method.getModifiers()) || method.getParameterCount() != 1 || method.getParameterTypes()[0] != int[].class || method.getReturnType() != void.class) {
                return;
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            int[] arg = array.clone(); // {9, 7, 5, 3, 1, 2, 4, 6, 8};// array.clone();
            long start = System.nanoTime();
            try {
                method.invoke(null, (Object) arg);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            long end = System.nanoTime();

            if (arg.length > 1) {
                boolean desc = arg[0] > arg[1];
                for (int i = 2; i < arg.length; i++) {
                    if (desc) {
                        // 降序
                        if (arg[i - 1] < arg[i]) {
                            buf.append(method.getName()).append(": ").append("排序出错\n");
                            return;
                        }
                        continue;
                    }
                    if (arg[i - 1] > arg[i]) {
                        // 升序
                        buf.append(method.getName()).append(": ").append("排序出错\n");
                        return;
                    }
                }
            }

            buf.append(method.getName()).append(": ").append(TimeUnit.NANOSECONDS.toMillis(end - start)).append(' ').append(String.format("%.100s", Arrays.toString(arg))).append('\n');
        });
        System.out.println(buf);
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 排序: https://www.cnblogs.com/l199616j/p/10742603.html
     */

    /**
     * 选择
     */
    public static void selectionSort(int[] array) {
    }

    /**
     * 冒泡
     */
    public static void bubbleSort(int[] array) {
    }

    /**
     * 插入
     */
    public static void insertionSort(int[] array) {

    }

    /**
     * 插入优化: 二分插入
     * https://zhuanlan.zhihu.com/p/122293204
     */
    public static void binaryInsertionSort(int[] array) {
    }

    /**
     * 计数
     * https://www.cnblogs.com/kyoner/p/10604781.html
     */
    public static void countingSort(int[] array) {
    }

    /**
     * 基数
     */
    public static void radixSort(int[] array) {
    }


    /**
     * 快速: 单路 双路 三路
     *   http://events.jianshu.io/p/63af86557eab
     *   https://zhuanlan.zhihu.com/p/113548140
     *   https://cloud.tencent.com/developer/article/1755422
     */

    /**
     * 单路快排, 当数组有序或重复元素过多最坏时间复杂度O(n^2)
     */
    public static void quickSort1(int[] array) {
    }

    private static void quickSort1(int[] array, int left, int right) {
    }

    /**
     * 双路快排, 优化重复元素
     * https://www.jianshu.com/p/641e6860dc05
     */
    public static void quickSort2(int[] array) {
    }

    /**
     * 覆盖实现, 覆盖填坑
     */
    private static void quickSort2Cover(int[] array, int left, int right) {
    }

    /**
     * 交换实现
     */
    private static void quickSort2Swap1(int[] array, int left, int right) {
    }

    /**
     * 三路快速, 快速排序优化, 快速 + 基数
     */
    public static void quickSort3(int[] array) {
    }

    private static void quickSort3(int[] array, int left, int right) {
    }

    /**
     * 双轴快速
     * https://www.jianshu.com/p/2ae6ba100d3a
     * https://zhuanlan.zhihu.com/p/374041792
     */
    public static void dualPivotQuicksort(int[] array) {

    }

    /**
     * 内省, 快速排序优化, 快速 + 堆 + 插入, 快排递归一定次数就进行堆排序, 当少了部分有序时时使用插入
     * https://www.lmlphp.com/user/151096/article/item/3537104/
     */
    public static void introSort(int[] array) {

    }

    /**
     * 归并
     */
    public static void mergeSort(int[] array) {
    }

    /**
     * 自顶而下
     */
    private static void mergeSortT(int[] array, int left, int right) {
    }

    /**
     * 自底而上
     */
    private static void mergeSortB(int[] array) {
    }

    /**
     * 堆
     * https://www.jianshu.com/p/6e3db5631dc3
     * https://www.cnblogs.com/l199616j/p/10741093.html
     * https://baijiahao.baidu.com/s?id=1720269709730882598
     */
    public static void heapSort(int[] array) {

    }

    /**
     * 希尔
     * https://baijiahao.baidu.com/s?id=1719645128431014366
     */
    public static void shellSort(int[] array) {
    }

    /**
     * 归并 + 插入
     * https://www.jianshu.com/p/892ebd063ad9
     */
    public static void timSort(int[] array) {

    }

    /**
     * 块
     */
    public static void blockSort(int[] array) {

    }

    /**
     * 平滑
     */
    public static void smoothSort(int[] array) {

    }
}
