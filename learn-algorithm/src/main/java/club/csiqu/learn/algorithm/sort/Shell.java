package club.csiqu.learn.algorithm.sort;

/**
 * 希尔排序
 * <p>
 * 1.选择一个增量序列 t1，t2，…，tk，其中 ti大于 tj，tk=1。
 * 2.按增量序列个数 k，对序列进行 k趟排序。
 * 3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m的子序列，
 * 4.分别对各子表进行直接插入排序。
 * 5.仅增量因子为 1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * @author chensiqu
 * @since 2019/3/6 14:24
 */
public class Shell implements Sortable {

    @Override
    public void sort(int[] array) {
        shell(array);
    }

    /**
     * 希尔排序
     *
     * @param array 待排序数组
     */
    private void shell(int[] array) {
        // 组数
        int group = array.length >> 1;
        int temp;
        while (group > 0) {
            // 对分好的组别进行插入排序
            for (int i = group, length = array.length; i < length; i++) {
                // 寄存待插入数字
                temp = array[i];
                // 记录前一个位置的数字下标
                int preIndex = i - group;
                // 插入排序，如果前面的数字比 temp大则后移。preIndex前移。
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + group] = array[preIndex];
                    preIndex = preIndex - group;
                }
                // 将目标放入位置
                array[preIndex + group] = temp;
            }
            // 重新分组
            group = group >> 1;
        }
    }
}