package cclub.csiqu.learn.sort;

import java.util.Random;

class ArrayUtils {

    /**
     * 产生 0到 {@code scope}范围内的随机数
     *
     * @param length 数组长度
     * @param scope  数据范围
     * @return 随机数数组
     */
    static int[] getRand(int length, int scope) {

        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(scope);
        }
        return array;
    }

    /**
     * 交换数组内元素
     *
     * @param array 数组
     * @param i     数组下标
     * @param j     数组下标
     */
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     *
     * @param array 数组
     */
    static void showRand(int[] array) {
        for (int i1 : array) {
            System.out.print(" " + i1);
        }
        System.out.println();
    }
}