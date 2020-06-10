package club.csiqu.learn.algorithm.sort.space;

import club.csiqu.learn.algorithm.sort.Sortable;

/**
 * 计数排序，以空间换时间。
 * <p>
 * 1.找出待排序的数组中最大和最小的元素。
 * 2.统计数组中每个值为 i的元素出现的次数，存入数组 C的第 i项。
 * 3.对所有的计数累加（从 C中的第一个元素开始，每一项和前一项相加）。
 * 4.反向填充目标数组：将每个元素 i放在新数组的第 C(i)项，每放一个元素就将 C(i)减去 1。
 *
 * @author chensiqu
 * @since 2019/3/22 10:43
 */
public class Counting implements Sortable {

    @Override
    public void sort(int[] array) {
        counting(array);
    }

    private void counting(int[] array) {
        int max = array[0];
        int min = array[0];
        // 计算数组的最大值和最小值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max);
            min = Math.min(array[i], min);
        }

        int[] temp = new int[max - min + 1];
        // temp数组下标表示目标数组的数值
        for (int i1 : array) {
            temp[i1 - min]++;
        }

        int index = 0;
        int i = 0;
        // 反向填充目标数组
        while (index < array.length) {
            if (temp[i] != 0) {
                array[index] = i + min;
                temp[i]--;
                index++;
            } else {
                i++;
            }
        }
    }
}