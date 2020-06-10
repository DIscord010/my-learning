package club.csiqu.learn.algorithm.sort.recursive;

import club.csiqu.learn.algorithm.sort.Sortable;

/**
 * 归并排序
 * <p>
 * 把长度为 n的输入序列分成两个长度为 n/2的子序列，
 * 对这两个子序列分别采用归并排序，
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * @author chensiqu
 * @since 2019/3/21 15:22
 */
public class Merge implements Sortable {

    @Override
    public void sort(int[] array) {
        merge(array);
    }

    /**
     * 使用数组下标来区分子序列，减少使用额外的内存空间。
     *
     * @param array 待排序数组
     */
    private void merge(int[] array) {
        int[] temp = new int[array.length];
        merge(array, 0, array.length - 1, temp);
    }

    private void merge(int[] array, int left, int right, int[] temp) {
        // 当数组长度为 1时结束递归
        if (left < right) {
            int mid = (left + right) >> 1;
            // 左序列递归
            merge(array, left, mid, temp);
            // 右序列递归
            merge(array, mid + 1, right, temp);
            // 对两个序列进行合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 归并排序，合并两个已排序序列。
     * <p>
     * {@code left}到 {@code mid}为左边序列，{@code mid+1}到 {@code right}为右边序列
     *
     * @param array 数组
     * @param left  开始下标
     * @param right 结束下标
     * @param mid   中间下标
     * @param temp  辅助数组
     */
    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        // 左序列开始下标
        int i = left;
        // 右序列开始下标
        int j = mid + 1;
        int k = 0;
        // 进行循环比较，每次将小的加入放入 temp数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 结束后，可能出现的左序列剩余部分
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 结束后，可能出现的右序列剩余部分
        while (j <= right) {
            temp[k++] = array[j++];
        }
        k = 0;
        // 将排序结果 temp数组复制回 array数组
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

}