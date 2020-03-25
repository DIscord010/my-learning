package cclub.csiqu.learn.sort;

import java.util.ArrayList;

/**
 * 基数排序
 * <p>
 * 非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为 O(kn)。
 * n为数组长度，k为数组中的数的最大的位数。
 * <p>
 * 基数排序是按照低位先排序，然后收集。
 * 再按照高位排序，然后再收集。
 *
 * @author chensiqu
 * @since 2019/3/22 10:44
 */
public class Radix implements Sortable {

    /**
     * 基数排序
     *
     * @param array 待排序数组
     */
    private void radix(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = array[0];
        // 找出最大的数
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
        // 最大数的位数
        int maxDigit = 0;
        // 获取最大数的位数
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        // 十个桶
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>(10000));
        }
        int mod = 10, div = 1;
        int index;
        // 从个位开始
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            // 依次放入桶中
            for (int i1 : array) {
                // 取得该位数的数值
                int num = (i1 % mod) / div;
                lists.get(num).add(i1);
            }
            index = 0;
            // 依次放回目标数组
            for (ArrayList<Integer> list : lists) {
                for (Integer i1 : list) {
                    array[index++] = i1;
                }
                list.clear();
            }
        }
    }

    @Override
    public void sort(int[] array) {
        radix(array);
    }
}