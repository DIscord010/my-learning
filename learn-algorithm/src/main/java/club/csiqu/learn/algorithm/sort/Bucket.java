package club.csiqu.learn.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 * <p>
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，
 * 高效与否的关键就在于这个映射函数的确定。
 * <p>
 * 桶排序(Bucket sort)的工作的原理：
 * 假设输入数据服从均匀分布，
 * 将数据分到有限数量的桶里，
 * 每个桶再分别排序(有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序)。
 *
 * @author chensiqu
 * @since 2019/3/22 10:43
 */
public class Bucket implements Sortable {

    /**
     * 桶排序
     *
     * @param array      目标数组
     * @param bucketSize 桶的大小即数据范围
     */
    private void bucket(int[] array, int bucketSize) {
        if (array.length < 1) {
            return;
        }
        // 计算目标数组的最大值和最小值
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        // 桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            lists.add(new ArrayList<>(10000));
        }
        // 把数字装入对应的桶
        for (int i1 : array) {
            lists.get((i1 - min) / bucketSize).add(i1);
        }
        // 每个桶进行排序
        for (ArrayList<Integer> arrayList : lists) {
            if (arrayList != null) {
                Collections.sort(arrayList);
            }
        }
        int index = 0;
        // 反向填充目标数组
        for (ArrayList<Integer> list : lists) {
            for (Integer i1 : list) {
                array[index++] = i1;
            }
        }
    }

    @Override
    public void sort(int[] array) {
        // 100个桶
        bucket(array, 100);
    }
}